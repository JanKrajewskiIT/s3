package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class InternalInvoiceGoodServiceImpl implements InternalInvoiceGoodService {

	private final static String ACCESS_LEVEL = "documentManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public InternalInvoiceGoodDTO getOneById(Long id) {
    	return null;
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<InternalInvoiceGoodDTO> getAll() {
    	return null;
    }
    
}
