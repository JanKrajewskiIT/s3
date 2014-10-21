package pl.lodz.p.was04.department.core.endpoint.documents;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.DocumentSettingsManagerLocal;

/**
 *
 * @author milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentSettingsEnpoint implements DocumentSettingsEndpointLocal {

	@Autowired
    private DocumentSettingsManagerLocal documentSettingsManager;

    @RolesAllowed("documentManagement")
    @Override
    public String findDefaultDocumentPlace() {
        return documentSettingsManager.findDefaultDocumentPlace();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void updateDefaultDocumentPlace(String newDocumentPlace) {
        documentSettingsManager.updateDefaultDocumentPlace(newDocumentPlace);
    }

}
