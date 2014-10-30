package pl.lodz.p.was04.department.core.service.document;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.document.PaymentMethodDTO;

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
