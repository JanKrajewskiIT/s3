package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.domain.document.PaymentMethod;
import pl.lodz.p.project.core.dto.document.PaymentMethodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

/**
 *
 * @author Milczu, Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PaymentMethodServiceImpl extends AbstractService<PaymentMethod, PaymentMethodDTO> implements PaymentMethodService {

	private final static String ACCESS_LEVEL = "documentManagement";
	
	@RolesAllowed(ACCESS_LEVEL)
    @Override
    public PaymentMethodDTO getOneById(Long id) {
		return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<PaymentMethodDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(PaymentMethodDTO paymentMethodDTO) {
        super.save(paymentMethodDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(PaymentMethodDTO paymentMethodDTO) {
    	super.delete(paymentMethodDTO);
    }

}
