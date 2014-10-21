package pl.lodz.p.was04.department.core.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.goods.GoodDTO;
import pl.lodz.p.was04.department.core.endpoint.goods.GoodsManagementEndpointLocal;

/**
 *
 * @author Łukasz
 */
@Named(value = "goodDTOConverter")
@Scope("request")
public class GoodDTOConverter implements Converter {

    public GoodDTOConverter() { }
    
    @Autowired
    GoodsManagementEndpointLocal goodsManagementEndpointLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((goodsManagementEndpointLocal == null)) {
            throw new ConverterException("Endpoint not found");
        }
        if (!value.contains("null")) {
            //TODO changed from string to long, we need to chek it
            Long id = Long.parseLong(value);
            return goodsManagementEndpointLocal.findById(id);
        } else {
            return new GoodDTO();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if ((value instanceof GoodDTO)) {
            GoodDTO goodDTO = (GoodDTO) value;
            return String.valueOf(goodDTO.getId());
        }
        return String.valueOf(value);
    }
}
