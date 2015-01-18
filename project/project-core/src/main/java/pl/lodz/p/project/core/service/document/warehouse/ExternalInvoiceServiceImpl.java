package pl.lodz.p.project.core.service.document.warehouse;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dao.document.warehouse.ExternalInvoiceDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Jan Krajewski
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

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(ExternalInvoiceDTO invoice) {
        super.save(invoice);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<ExternalInvoiceDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<ExternalInvoice> page = ((ExternalInvoiceDao) dao).search(searchQuery, pageRequest);
        List<ExternalInvoiceDTO> list = Lists.transform(page.getContent(), transformer);
        return new PageImpl<>(list, pageRequest, page.getTotalElements());
    }
}
