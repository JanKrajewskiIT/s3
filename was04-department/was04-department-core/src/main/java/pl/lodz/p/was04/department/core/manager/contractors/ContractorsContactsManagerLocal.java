package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.contractors.ContractorContact;

/**
 *
 * @author Janiu
 */
public interface ContractorsContactsManagerLocal {
    
    public List<ContractorContact> getContractorsContacts();
    
    public ContractorContact getById(Long contractorContactId);
}
