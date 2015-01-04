package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ExternalInvoiceGoodServiceImpl implements ExternalInvoiceGoodService {

	private final static String ACCESS_LEVEL = "documentManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public ExternalInvoiceGoodDTO getOneById(Long id) {
    	return null;
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<ExternalInvoiceGoodDTO> getAll() {
    	return null;
    }
    
}
