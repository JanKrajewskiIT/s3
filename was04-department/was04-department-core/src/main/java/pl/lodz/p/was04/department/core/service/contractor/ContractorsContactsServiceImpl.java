package pl.lodz.p.was04.department.core.service.contractor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.contractor.ContractorContactConverter;
import pl.lodz.p.was04.department.core.dao.contractor.ContractorContactDao;
import pl.lodz.p.was04.department.core.domain.contractor.ContractorContact;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorContactDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsContactsServiceImpl implements ContractorsContactsService {

    @Autowired
    ContractorContactDao contractorContactsDao;
    
    @Autowired
    ContractorContactConverter contractorContactConverter;

    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorContactDTO> getContractorsContacts() {
    	List<ContractorContactDTO> contractorContactList = new ArrayList<>();
        for (ContractorContact contractorContact : contractorContactsDao.findAll()) {
        	ContractorContactDTO contractContactDTO = contractorContactConverter.convertEntity(contractorContact);
            contractorContactList.add(contractContactDTO);
        }
        return contractorContactList;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorContactDTO getContractorContact(Long id) {
    	ContractorContact contractorContact = contractorContactsDao.findOne(id);
    	return contractorContactConverter.convertEntity(contractorContact);
    }
}
