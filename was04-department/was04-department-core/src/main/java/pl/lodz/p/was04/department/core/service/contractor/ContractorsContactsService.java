package pl.lodz.p.was04.department.core.service.contractor;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.contractor.ContractorContactDTO;

/**
 *
 * @author Janiu
 */
public interface ContractorsContactsService {

    public List<ContractorContactDTO> getContractorsContacts();
    
    public ContractorContactDTO getContractorContact(Long id);
}
