package pl.lodz.p.project.core.service.document.sale;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.converter.document.sale.SaleDocumentExternalInvoiceConverter;
import pl.lodz.p.project.core.dao.document.sale.SaleDocumentDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceServiceImpl;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Janiu
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class SaleDocumentServiceImpl extends AbstractService<SaleDocument, SaleDocumentDTO> implements SaleDocumentService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @Autowired
    private ExternalInvoiceServiceImpl externalInvoiceService;

    @Autowired
    private SaleDocumentExternalInvoiceConverter invoiceConverter;

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public SaleDocumentDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<SaleDocumentDTO> getAll() {
        return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public SaleDocument save(SaleDocumentDTO saleDocumentDTO) {
        if (saleDocumentDTO.isWarehouseResult() && saleDocumentDTO.isNew()) {
            externalInvoiceService.save(invoiceConverter.convertToExternal(saleDocumentDTO));
        }
        return super.save(saleDocumentDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(SaleDocumentDTO saleDocumentDTO) {
        super.delete(saleDocumentDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<SaleDocumentDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<SaleDocument> page = ((SaleDocumentDao) dao).search(searchQuery, pageRequest);
        List<SaleDocumentDTO> list = Lists.transform(page.getContent(), transformer);
        return new PageImpl<>(list, pageRequest, page.getTotalElements());
    }
}
