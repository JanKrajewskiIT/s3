package pl.lodz.p.project.core.service.document.purchase;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.converter.document.purchase.PurchaseInvoiceExternalInvoiceConverter;
import pl.lodz.p.project.core.dao.document.purchase.PurchaseInvoiceDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.purchase.PurchaseInvoice;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceDTO;
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
public class PurchaseInvoiceServiceImpl extends AbstractService<PurchaseInvoice, PurchaseInvoiceDTO> implements PurchaseInvoiceService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @Autowired
    private ExternalInvoiceServiceImpl externalInvoiceService;

    @Autowired
    private PurchaseInvoiceExternalInvoiceConverter invoiceConverter;

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public PurchaseInvoiceDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<PurchaseInvoiceDTO> getAll() {
        return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public PurchaseInvoice save(PurchaseInvoiceDTO purchaseDocumentDTO) {
        if (purchaseDocumentDTO.isWarehouseResult() && purchaseDocumentDTO.isNew()) {
            externalInvoiceService.save(invoiceConverter.convertToExternal(purchaseDocumentDTO));
        }
        return super.save(purchaseDocumentDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(PurchaseInvoiceDTO purchaseDocumentDTO) {
        super.delete(purchaseDocumentDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<PurchaseInvoiceDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<PurchaseInvoice> page = ((PurchaseInvoiceDao) dao).search(searchQuery, pageRequest);
        List<PurchaseInvoiceDTO> list = Lists.transform(page.getContent(), transformer);
        return new PageImpl<>(list, pageRequest, page.getTotalElements());
    }
}
