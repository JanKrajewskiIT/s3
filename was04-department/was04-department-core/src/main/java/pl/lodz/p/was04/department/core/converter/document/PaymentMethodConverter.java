package pl.lodz.p.was04.department.core.converter.document;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.document.PaymentMethod;
import pl.lodz.p.was04.department.core.dto.document.PaymentMethodDTO;

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
