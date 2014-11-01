package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;

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
