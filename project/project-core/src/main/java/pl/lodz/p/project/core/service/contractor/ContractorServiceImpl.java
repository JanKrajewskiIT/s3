package pl.lodz.p.project.core.service.contractor;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dao.contractor.ContractorDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorServiceImpl extends AbstractService<Contractor, ContractorDTO> implements ContractorService {

	private final static String ACCESS_LEVEL = "contractorManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<ContractorDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(Long id) {
    	super.delete(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Contractor save(ContractorDTO contractorDTO) {
    	return super.save(contractorDTO);
    }
    
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public ContractorDTO getOneById(Long id) {
    	return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Contractor> pageGoods = ((ContractorDao) dao).search(searchQuery, pageRequest);
        List<ContractorDTO> contractorList = Lists.transform(pageGoods.getContent(), transformer);
        return new PageImpl<>(contractorList, pageRequest, pageGoods.getTotalElements());
    }

}