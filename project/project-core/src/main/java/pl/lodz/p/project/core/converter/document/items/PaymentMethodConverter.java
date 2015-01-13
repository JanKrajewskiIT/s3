package pl.lodz.p.project.core.converter.document.items;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.items.PaymentMethod;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;

/**
 *
 * @author Milczu, Janiu
 */
@Named
@ApplicationScoped
public class PaymentMethodConverter implements Converter<PaymentMethod, PaymentMethodDTO>{

    @Override
    public PaymentMethod convertDTO(PaymentMethodDTO objectDTO) {
        PaymentMethod entity = new PaymentMethod();
        entity.setId(objectDTO.getId());
        entity.setMaturity(objectDTO.getMaturity());
        entity.setName(objectDTO.getName());
        return entity;
    }

    @Override
    public PaymentMethodDTO convertEntity(PaymentMethod entity) {
        PaymentMethodDTO objectDTO = new PaymentMethodDTO();
        objectDTO.setId(entity.getId());
        objectDTO.setMaturity(entity.getMaturity());
        objectDTO.setName(entity.getName());
        return objectDTO;
    }
    
}
