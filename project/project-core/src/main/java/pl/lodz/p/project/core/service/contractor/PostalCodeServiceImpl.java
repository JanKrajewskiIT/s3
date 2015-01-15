package pl.lodz.p.project.core.service.contractor;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.contractor.PostalCode;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PostalCodeServiceImpl extends AbstractService<PostalCode, PostalCodeDTO> implements PostalCodeService {

	private final static String ACCESS_LEVEL = "contractorManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<PostalCodeDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public PostalCodeDTO getOneById(Long id) {
    	return super.getOneById(id);
    }
    
}
