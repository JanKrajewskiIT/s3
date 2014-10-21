package pl.lodz.p.was04.department.core.converters.documents;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converters.Converter;
import pl.lodz.p.was04.department.core.domain.documents.PaymentMethod;
import pl.lodz.p.was04.department.core.dto.documents.PaymentMethodDTO;

/**
 *
 * @author milczu
 */
@Named
@ApplicationScoped
public class PaymentMethodConverter implements Converter<PaymentMethod, PaymentMethodDTO>{

    @Override
    public PaymentMethod convertDTO(PaymentMethodDTO objectDTO) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(objectDTO.getId());
        paymentMethod.setMaturity(objectDTO.getMaturity());
        paymentMethod.setName(objectDTO.getName());
        paymentMethod.setVersion(objectDTO.getVersion());
        return paymentMethod;
    }

    @Override
    public PaymentMethodDTO convertEntity(PaymentMethod entity) {
        PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO();
        paymentMethodDTO.setId(entity.getId());
        paymentMethodDTO.setMaturity(entity.getMaturity());
        paymentMethodDTO.setName(entity.getName());
        paymentMethodDTO.setVersion(entity.getVersion());
        return paymentMethodDTO;
    }
    
}
