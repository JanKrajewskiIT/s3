package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorContactDTO;

/**
 *
 * @author Janiu
 */
public interface ContractorsContactsManagementEndpointLocal {

    public List<ContractorContactDTO> getContractorsContacts();
    
    public ContractorContactDTO getContractorContact(Long id);
}
