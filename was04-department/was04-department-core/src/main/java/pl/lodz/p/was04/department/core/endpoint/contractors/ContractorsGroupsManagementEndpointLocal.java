package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorGroupDTO;

/**
 *
 * @author Janiu, milczu
 */
public interface ContractorsGroupsManagementEndpointLocal {

    List<ContractorGroupDTO> getContractorsGroups();
    
    ContractorGroupDTO getContractorGroup(Long id);

    Long add(ContractorGroupDTO clientGroupDTO);
    
    void edit(ContractorGroupDTO clientGroupDTO);
    
    void remove(ContractorGroupDTO clientGroupDTO);
}
