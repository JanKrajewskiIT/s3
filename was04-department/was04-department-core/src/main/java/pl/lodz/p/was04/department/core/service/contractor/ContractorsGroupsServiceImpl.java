package pl.lodz.p.was04.department.core.service.contractor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.contractor.ContractorGroupConverter;
import pl.lodz.p.was04.department.core.dao.contractor.ContractorGroupDao;
import pl.lodz.p.was04.department.core.domain.contractor.ContractorGroup;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsGroupsServiceImpl implements ContractorsGroupsService {

	@Autowired
    ContractorGroupDao contractorsGroupsDao;
	
	@Autowired
	ContractorGroupConverter contractorGroupConverter;

    @RolesAllowed("contractorGroupManagement")
    @Override
    public List<ContractorGroupDTO> getContractorsGroups() {
        List<ContractorGroupDTO> contractorGroupList = new ArrayList<>();
        for (ContractorGroup contractorGroup : contractorsGroupsDao.findAll()) {
        	ContractorGroupDTO contractorGroupDTO = contractorGroupConverter.convertEntity(contractorGroup);
        	contractorGroupList.add(contractorGroupDTO);
        }
        return contractorGroupList;
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public ContractorGroupDTO getContractorGroup(Long id) {
    	ContractorGroup contractorGroup = contractorsGroupsDao.findOne(id);
        return contractorGroupConverter.convertEntity(contractorGroup);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public Long add(ContractorGroupDTO contractorGroupDTO) {
    	ContractorGroup contractorGroup = contractorGroupConverter.convertDTO(contractorGroupDTO);
        contractorsGroupsDao.save(contractorGroup);
        return contractorGroup.getId();
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void edit(ContractorGroupDTO contractorGroupDTO) {
    	ContractorGroup contractorGroup = contractorGroupConverter.convertDTO(contractorGroupDTO);
        contractorsGroupsDao.save(contractorGroup);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void remove(ContractorGroupDTO contractorGroupDTO) {
    	ContractorGroup contractorGroup = contractorGroupConverter.convertDTO(contractorGroupDTO);
        contractorsGroupsDao.delete(contractorGroup);
    }

}
