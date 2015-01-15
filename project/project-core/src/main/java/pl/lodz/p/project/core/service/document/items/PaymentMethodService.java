package pl.lodz.p.project.core.service.document.items;

import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;

import java.util.List;

/**
 *
 * @author Milczu
 */
public interface PaymentMethodService {
    
    PaymentMethodDTO getOneById(Long id);

    List<PaymentMethodDTO> getAll();
        
    void save(PaymentMethodDTO paymentMethodDTO);
    
    void delete(PaymentMethodDTO paymentMethodDTO);
    
}
