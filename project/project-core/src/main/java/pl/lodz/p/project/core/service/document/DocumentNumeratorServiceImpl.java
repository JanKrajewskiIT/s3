package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.dao.document.DocumentNumeratorDao;
import pl.lodz.p.project.core.dto.document.DocumentFormat;
import pl.lodz.p.project.core.dto.document.DocumentSymbolBuilder;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.settings.SettingsPropertyKeys;
import pl.lodz.p.project.core.service.settings.SettingsPropertyService;

/**
 *
 * @author Milczu, Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentNumeratorServiceImpl implements DocumentNumeratorService {
	
    private DocumentSymbolBuilder documentSymbolBuilder = new DocumentSymbolBuilder();

    @Autowired
    private SettingsPropertyService settingsPropertyManager;
    
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
    public void updateDocumentFormat(String newDocumentFormat) {
        settingsPropertyManager.editScalarProperty(SettingsPropertyKeys.DOCUMENT_SYMBOL_FORMAT, newDocumentFormat);
    }

    @RolesAllowed("documentManagement")
    @Override
    public String currentFormat() {
        return settingsPropertyManager.findScalarProperty(SettingsPropertyKeys.DOCUMENT_SYMBOL_FORMAT);
    }

}
