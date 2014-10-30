package pl.lodz.p.was04.department.core.service.contractor;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.contractor.ContractorGroupDTO;

/**
 *
 * @author Janiu
 */
public interface ContractorsGroupsService {

    List<ContractorGroupDTO> getContractorsGroups();
    
    ContractorGroupDTO getContractorGroup(Long id);

    Long add(ContractorGroupDTO clientGroupDTO);
    
    void edit(ContractorGroupDTO clientGroupDTO);
    
    void remove(ContractorGroupDTO clientGroupDTO);
}
