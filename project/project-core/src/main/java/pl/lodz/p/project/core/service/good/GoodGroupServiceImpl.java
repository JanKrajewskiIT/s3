package pl.lodz.p.project.core.service.good;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.good.GoodGroup;
import pl.lodz.p.project.core.dto.good.GoodGroupDTO;
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
public class GoodGroupServiceImpl extends AbstractService<GoodGroup, GoodGroupDTO> implements GoodGroupService {

	private final static String ACCESS_LEVEL = "goodsGroupManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<GoodGroupDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public GoodGroupDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public GoodGroup save(GoodGroupDTO goodGroupDTO) {
    	return super.save(goodGroupDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(GoodGroupDTO goodGroupDTO) {
    	super.delete(goodGroupDTO);
    }
    
}
