/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.RoleDTO;
import pl.lodz.p.was04.department.core.endpoint.accountmanagement.AccountManagementEndpointLocal;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "roleDTOConverter")
@Scope("request")
public class RoleDTOConverter implements Converter {

    @Autowired
    private AccountManagementEndpointLocal accountManagementEndpoint;

    /**
     * Creates a new instance of RoleDTOConverter
     */
    public RoleDTOConverter() { }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((accountManagementEndpoint == null)) {
            throw new ConverterException("Endpoint not found");
        }
        try {
            return accountManagementEndpoint.getRoleByName(value);
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
            return roleDTO.getRoleName();
        }
        return String.valueOf(value);
    }

}
