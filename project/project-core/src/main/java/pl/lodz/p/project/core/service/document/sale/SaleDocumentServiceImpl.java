package pl.lodz.p.project.core.service.document.sale;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

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
        return super.save(saleDocumentDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(SaleDocumentDTO saleDocumentDTO) {
        super.delete(saleDocumentDTO);
    }

}
