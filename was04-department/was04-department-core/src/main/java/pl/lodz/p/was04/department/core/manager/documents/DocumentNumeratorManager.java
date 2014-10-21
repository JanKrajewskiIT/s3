package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.DocumentNumeratorDao;
import pl.lodz.p.was04.department.core.dto.documents.DocumentFormat;
import pl.lodz.p.was04.department.core.dto.documents.DocumentSymbolBuilder;
import pl.lodz.p.was04.department.core.manager.settings.SettingsPropertyKeys;
import pl.lodz.p.was04.department.core.manager.settings.SettingsPropertyManagerLocal;

/**
 *
 * @author milczu
 */
@Component
public class DocumentNumeratorManager implements DocumentNumeratorManagerLocal {

    private DocumentSymbolBuilder documentSymbolBuilder = new DocumentSymbolBuilder();

    @Autowired
    private SettingsPropertyManagerLocal settingsPropertyManager;
    
    @Autowired
    private DocumentNumeratorDao documentNumeratorDao;

    @RolesAllowed("documentManagement")
    @Override
    public String nextNumber(String documentType) {
        String previousSymbol = findPrevious(documentType);
        String currentFormatString = currentFormat();
        DocumentFormat currentFormat = DocumentFormat.forPattern(currentFormatString);
        if (previousSymbol == null || !hasPattern(previousSymbol, currentFormatString)) {
            return documentSymbolBuilder.buildFirst(documentType, currentFormat);
        } else {
            return documentSymbolBuilder.buildNext(previousSymbol, documentType, currentFormat);
        }
    }

    protected boolean hasPattern(String number, String pattern) {
        // TODO
        return true;
    }

    protected String findPrevious(String documentType) {
       //return null;
       return documentNumeratorDao.findPrevious(documentType);
    }

    @RolesAllowed("documentManagement")
    @Override
    public boolean isAvailable(String symbol, String documentType) {
        return documentNumeratorDao.isAvailable(symbol, documentType);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<String> availableFormats() {
        return DocumentFormat.availableFormats();
    }

    @RolesAllowed("documentManagement")
    @Override
    public String currentFormat() {
        return settingsPropertyManager.findScalarProperty(SettingsPropertyKeys.DOCUMENT_SYMBOL_FORMAT);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void updateDocumentFormat(String newDocumentFormat) {
        settingsPropertyManager.editScalarProperty(SettingsPropertyKeys.DOCUMENT_SYMBOL_FORMAT, newDocumentFormat);
    }

    public void setDocumentSymbolBuilder(DocumentSymbolBuilder documentSymbolBuilder) {
        this.documentSymbolBuilder = documentSymbolBuilder;
    }
}
