package pl.lodz.p.project.core.service.good;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.good.Tax;
import pl.lodz.p.project.core.dto.good.TaxDTO;
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
public class TaxServiceImpl extends AbstractService<Tax, TaxDTO> implements TaxService {

	private final static String ACCESS_LEVEL = "goodsManagement";
	private final static String SETTINGS_ACCESS_LEVEL = "settings";
		
    @RolesAllowed({SETTINGS_ACCESS_LEVEL, ACCESS_LEVEL})
    @Override
    public List<TaxDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public TaxDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(SETTINGS_ACCESS_LEVEL)
    @Override
    public void save(TaxDTO taxDTO) {
    	super.save(taxDTO);
    }

    @RolesAllowed(SETTINGS_ACCESS_LEVEL)
    @Override
    public void delete(TaxDTO taxDTO) {
    	super.delete(taxDTO);
    }
    
}
