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

import pl.lodz.p.was04.department.core.dto.contractor.ContractorDTO;
import pl.lodz.p.was04.department.core.service.contractor.ContractorsService;

/**
 *
 * @author Łukasz
 */
/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "contractorDTOConverter")
@Scope("request")
public class ContractorDTOConverter implements Converter {

    public ContractorDTOConverter() { }
    
    @Autowired
    ContractorsService contractorsManagementEndpointLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((contractorsManagementEndpointLocal == null)) {
            throw new ConverterException("Endpoint not found");
        }
        if (!value.contains("null")){
            //TODO changed from string to long, we need to chek it
            Long id = Long.parseLong(value);
        	return contractorsManagementEndpointLocal.findById(id);
        }
        return new ContractorDTO();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if ((value instanceof ContractorDTO)) {
            ContractorDTO contractorDTO = (ContractorDTO) value;
            return String.valueOf(contractorDTO.getId());
        }
        return String.valueOf(value);
    }
}
