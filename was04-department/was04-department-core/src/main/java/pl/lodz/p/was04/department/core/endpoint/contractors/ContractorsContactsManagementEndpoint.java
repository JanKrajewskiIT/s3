package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.contractors.ContractorContact;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorContactDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.contractors.ContractorsContactsManagerLocal;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsContactsManagementEndpoint implements ContractorsContactsManagementEndpointLocal {
	
	@Autowired
    ContractorsContactsManagerLocal contractorsContactsManagerLocal;

    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorContactDTO> getContractorsContacts() {
        return createContractorsContactsList(contractorsContactsManagerLocal.getContractorsContacts());
    }

    private List<ContractorContactDTO> createContractorsContactsList(List<ContractorContact> listOfEnties) {
        List<ContractorContactDTO> contractorContactList = new ArrayList<>();
        for (ContractorContact listOfEntie : listOfEnties) {
            contractorContactList.add(new ContractorContactDTO(listOfEntie));
        }
        return contractorContactList;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorContactDTO getContractorContact(Long id) {
        return new ContractorContactDTO(contractorsContactsManagerLocal.getById(id));
    }
}
