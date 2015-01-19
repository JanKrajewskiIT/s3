package pl.lodz.p.project.core.service.good;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.good.Unit;
import pl.lodz.p.project.core.dto.good.UnitDTO;
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
public class UnitServiceImpl extends AbstractService<Unit, UnitDTO> implements UnitService {

	private final static String ACCESS_LEVEL = "goodsManagement";
	private final static String SETTINGS_ACCESS_LEVEL = "settings";
	
    @RolesAllowed({SETTINGS_ACCESS_LEVEL, ACCESS_LEVEL})
    @Override
    public List<UnitDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public UnitDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(SETTINGS_ACCESS_LEVEL)
    @Override
    public Unit save(UnitDTO unitDTO) {
    	return super.save(unitDTO);
    }

    @RolesAllowed(SETTINGS_ACCESS_LEVEL)
    @Override
    public void delete(UnitDTO unitDTO) {
    	super.delete(unitDTO);
    }
    
}
