package pl.lodz.p.was04.department.core.service.document;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.service.settings.SettingsPropertyKeys;
import pl.lodz.p.was04.department.core.service.settings.SettingsPropertyService;

/**
 *
 * @author Milczu, Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentSettingsServiceImpl implements DocumentSettingsService {

    @Autowired
    private SettingsPropertyService settingsPropertyManager;

    @RolesAllowed("documentManagement")
    @Override
    public String findDefaultDocumentPlace() {
        return settingsPropertyManager.findScalarProperty(SettingsPropertyKeys.DOCUMENT_DEFAULT_PLACE);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void updateDefaultDocumentPlace(String newDocumentPlace) {
        settingsPropertyManager.editScalarProperty(SettingsPropertyKeys.DOCUMENT_DEFAULT_PLACE, newDocumentPlace);
    }

}