package pl.lodz.p.project.core.jsf.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.service.account.RoleService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 * Created by lukasz on 30.01.15.
 */
@Named(value = "roleDTOConverter")
@Scope("request")
public class RoleDTOConverter implements Converter {

    @Autowired
    private RoleService roleService;

    /**
     * Creates a new instance of RoleDTOConverter
     */
    public RoleDTOConverter() { }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return roleService.getRoleByName(value);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if ((value instanceof RoleDTO)) {
            RoleDTO roleDTO = (RoleDTO) value;
            return roleDTO.getName();
        }
        return String.valueOf(value);
    }

}
