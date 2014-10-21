package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.contractors.ContractorGroup;

/**
 *
 * @author Janiu
 */
public interface ContractorsGroupsManagerLocal {

    List<ContractorGroup> getContractorsGroups();
    
    ContractorGroup getById(Long goodId);
    
    Long add(ContractorGroup clientGroup);

    void edit(ContractorGroup clientGroup);
    
    void remove(ContractorGroup clientGroup);
}
