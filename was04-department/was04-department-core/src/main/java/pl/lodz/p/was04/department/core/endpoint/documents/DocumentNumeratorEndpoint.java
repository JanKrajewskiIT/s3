package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.DocumentNumeratorManagerLocal;

/**
 *
 * @author milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentNumeratorEndpoint implements DocumentNumeratorEndpointLocal {

    @Autowired
    private DocumentNumeratorManagerLocal documentNumeratorManager;

    @RolesAllowed("documentManagement")
    @Override
    public String nextNumber(String documentType) {
        return documentNumeratorManager.nextNumber(documentType);
    }

    @RolesAllowed("documentManagement")
    @Override
    public boolean isAvailable(String symbol, String documentType) {
        return documentNumeratorManager.isAvailable(symbol, documentType);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<String> availableFormats() {
        return documentNumeratorManager.availableFormats();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void updateDocumentFormat(String newDocumentFormat) {
        documentNumeratorManager.updateDocumentFormat(newDocumentFormat);
    }

    @RolesAllowed("documentManagement")
    @Override
    public String currentFormat() {
        return documentNumeratorManager.currentFormat();
    }

}
