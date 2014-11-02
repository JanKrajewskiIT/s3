package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.contractor.ContractorGroupConverter;
import pl.lodz.p.project.core.dao.contractor.ContractorGroupDao;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsGroupsServiceImpl implements ContractorsGroupsService {

	@Autowired
    ContractorGroupDao contractorGroupDao;
	
	@Autowired
	ContractorGroupConverter contractorGroupConverter;

    @RolesAllowed("contractorGroupManagement")
    @Override
    public List<ContractorGroupDTO> getContractorsGroups() {
    	Transformer<ContractorGroup, ContractorGroupDTO> transformer = new Transformer<>(contractorGroupConverter);
    	return Lists.transform(contractorGroupDao.findAll(), transformer);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public ContractorGroupDTO getContractorGroup(Long id) {
    	ContractorGroup contractorGroup = contractorGroupDao.findOne(id);
        return contractorGroupConverter.convertEntity(contractorGroup);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public Long add(ContractorGroupDTO contractorGroupDTO) {
    	ContractorGroup contractorGroup = contractorGroupConverter.convertDTO(contractorGroupDTO);
        contractorGroupDao.save(contractorGroup);
        return contractorGroup.getId();
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void edit(ContractorGroupDTO contractorGroupDTO) {
    	ContractorGroup contractorGroup = contractorGroupConverter.convertDTO(contractorGroupDTO);
        contractorGroupDao.save(contractorGroup);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void remove(ContractorGroupDTO contractorGroupDTO) {
    	ContractorGroup contractorGroup = contractorGroupConverter.convertDTO(contractorGroupDTO);
        contractorGroupDao.delete(contractorGroup);
    }

}
