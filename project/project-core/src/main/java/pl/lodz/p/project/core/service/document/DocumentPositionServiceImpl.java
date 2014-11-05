package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.domain.document.DocumentPosition;
import pl.lodz.p.project.core.dto.document.DocumentPositionDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentPositionServiceImpl extends AbstractService<DocumentPosition, DocumentPositionDTO> implements DocumentPositionService {

	private final static String ACCESS_LEVEL = "documentManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public DocumentPositionDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<DocumentPositionDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void edit(List<DocumentPositionDTO> documentPositionList) {
    	for(DocumentPositionDTO documentPositionDTO : documentPositionList) {
    		super.save(documentPositionDTO);
    	}
    }
    
}
