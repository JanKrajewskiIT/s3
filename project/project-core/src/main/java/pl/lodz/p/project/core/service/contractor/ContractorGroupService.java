package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;

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
