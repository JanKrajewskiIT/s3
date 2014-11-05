package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.domain.document.SaleDocument;
import pl.lodz.p.project.core.dto.document.SaleDocumentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

/**
 *
 * @author Janiu
 */
@Component
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
    public void save(SaleDocumentDTO saleDocumentDTO) {
    	super.save(saleDocumentDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(SaleDocumentDTO saleDocumentDTO) {
    	super.delete(saleDocumentDTO);
    }
    
}
