package pl.lodz.p.project.core.service.document.warehouse;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class InternalInvoiceServiceImpl extends AbstractService<InternalInvoice, InternalInvoiceDTO> implements InternalInvoiceService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public InternalInvoiceDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<InternalInvoiceDTO> getAll() {
        return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(InternalInvoiceDTO invoice) {
        super.save(invoice);
    }

}
