package pl.lodz.p.was04.department.core.manager.documents;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.manager.settings.SettingsPropertyKeys;
import pl.lodz.p.was04.department.core.manager.settings.SettingsPropertyManagerLocal;

/**
 *
 * @author milczu
 */
@Component
public class DocumentSettingsManager implements DocumentSettingsManagerLocal {

    @Autowired
    private SettingsPropertyManagerLocal settingsPropertyManager;

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
