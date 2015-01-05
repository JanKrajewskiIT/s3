package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ExternalInvoiceServiceImpl extends AbstractService<ExternalInvoice, ExternalInvoiceDTO> implements ExternalInvoiceService {

	private final static String ACCESS_LEVEL = "documentManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public ExternalInvoiceDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<ExternalInvoiceDTO> getAll() {
    	return super.getAll();
    }
    
}
