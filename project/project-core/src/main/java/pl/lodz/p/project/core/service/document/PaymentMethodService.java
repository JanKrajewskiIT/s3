package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.PaymentMethodDTO;

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
