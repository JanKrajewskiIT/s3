package pl.lodz.p.project.core.service.contractor;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
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
public class ContractorGroupServiceImpl extends AbstractService<ContractorGroup, ContractorGroupDTO> implements ContractorGroupService {

	private final static String ACCESS_LEVEL = "contractorGroupManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<ContractorGroupDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public ContractorGroupDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(ContractorGroupDTO contractorGroupDTO) {
    	super.save(contractorGroupDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(ContractorGroupDTO contractorGroupDTO) {
    	super.delete(contractorGroupDTO);
    }

}
