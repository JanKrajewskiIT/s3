package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.PaymentMethodDTO;

/**
 *
 * @author Milczu
 */
public interface PaymentMethodsService {
    
    PaymentMethodDTO getById(Long id);

    List<PaymentMethodDTO> getPaymentMethods();
    
    Long add(PaymentMethodDTO paymentMethod);
    
    void edit(PaymentMethodDTO paymentMethod);
    
    void remove(PaymentMethodDTO paymentMethod);
}
