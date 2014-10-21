package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.documents.PaymentMethodDTO;

/**
 *
 * @author milczu
 */
public interface PaymentMethodsManagentEndpointLocal {
    
    PaymentMethodDTO getById(Long id);

    List<PaymentMethodDTO> getPaymentMethods();
    
    Long add(PaymentMethodDTO paymentMethod);
    
    void edit(PaymentMethodDTO paymentMethod);
    
    void remove(PaymentMethodDTO paymentMethod);
}
