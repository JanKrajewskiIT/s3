package pl.lodz.p.project.core.service.document.warehouse;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Service
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

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(ExternalInvoiceDTO invoice) {
        super.save(invoice);
    }
}
