package pl.lodz.p.project.core.service.contractor;

import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface ContractorGroupService {

    List<ContractorGroupDTO> getAll();
    
    ContractorGroupDTO getOneById(Long id);
    
    void save(ContractorGroupDTO clientGroupDTO);
    
    void delete(ContractorGroupDTO clientGroupDTO);
    
}
