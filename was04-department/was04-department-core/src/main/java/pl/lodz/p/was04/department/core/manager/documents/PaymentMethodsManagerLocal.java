package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.PaymentMethod;

/**
 *
 * @author milczu
 */
public interface PaymentMethodsManagerLocal {
    
    PaymentMethod getById(Long id);

    List<PaymentMethod> getPaymentMethods();
    
    Long add(PaymentMethod paymentMethod);
    
    void edit(PaymentMethod paymentMethod);
    
    void remove(PaymentMethod paymentMethod);
}
