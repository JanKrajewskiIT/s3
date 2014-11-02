package pl.lodz.p.project.core.service.contractor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.contractor.ContractorContactConverter;
import pl.lodz.p.project.core.dao.contractor.ContractorContactDao;
import pl.lodz.p.project.core.domain.contractor.ContractorContact;
import pl.lodz.p.project.core.dto.contractor.ContractorContactDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsContactsServiceImpl implements ContractorsContactsService {

    @Autowired
    ContractorContactDao contractorContactDao;
    
    @Autowired
    ContractorContactConverter contractorContactConverter;

    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorContactDTO> getContractorsContacts() {
    	List<ContractorContactDTO> contractorContactList = new ArrayList<>();
        for (ContractorContact contractorContact : contractorContactDao.findAll()) {
        	ContractorContactDTO contractContactDTO = contractorContactConverter.convertEntity(contractorContact);
            contractorContactList.add(contractContactDTO);
        }
        return contractorContactList;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorContactDTO getContractorContact(Long id) {
    	ContractorContact contractorContact = contractorContactDao.findOne(id);
    	return contractorContactConverter.convertEntity(contractorContact);
    }
}
