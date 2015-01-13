package pl.lodz.p.project.core.service.document.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.settings.SettingsPropertyKeys;
import pl.lodz.p.project.core.service.settings.SettingsPropertyService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

/**
 * @author Milczu, Janiu
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class DocumentSettingsServiceImpl implements DocumentSettingsService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @Autowired
    private SettingsPropertyService settingsPropertyManager;

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public String findDefaultDocumentPlace() {
        return settingsPropertyManager.findScalarProperty(SettingsPropertyKeys.DOCUMENT_DEFAULT_PLACE);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void updateDefaultDocumentPlace(String newDocumentPlace) {
        settingsPropertyManager.editScalarProperty(SettingsPropertyKeys.DOCUMENT_DEFAULT_PLACE, newDocumentPlace);
    }

}
