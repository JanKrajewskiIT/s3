package pl.lodz.p.project.core.converter.document.items;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.items.PaymentMethod;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

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
        entity.setVersion(objectDTO.getVersion());
        entity.setMaturity(objectDTO.getMaturity());
        entity.setName(objectDTO.getName());
        return entity;
    }

    @Override
    public PaymentMethodDTO convertEntity(PaymentMethod entity) {
        PaymentMethodDTO objectDTO = new PaymentMethodDTO();
        objectDTO.setId(entity.getId());
        objectDTO.setVersion(entity.getVersion());
        objectDTO.setMaturity(entity.getMaturity());
        objectDTO.setName(entity.getName());
        return objectDTO;
    }
    
}
