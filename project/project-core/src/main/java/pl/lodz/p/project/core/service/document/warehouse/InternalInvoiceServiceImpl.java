package pl.lodz.p.project.core.service.document.warehouse;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.dao.document.warehouse.InternalInvoiceDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
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

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<InternalInvoiceDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<InternalInvoice> page = ((InternalInvoiceDao) dao).search(searchQuery, pageRequest);
        List<InternalInvoiceDTO> list = Lists.transform(page.getContent(), transformer);
        return new PageImpl<>(list, pageRequest, page.getTotalElements());
    }

}
