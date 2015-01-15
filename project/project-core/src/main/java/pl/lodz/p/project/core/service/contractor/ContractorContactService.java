package pl.lodz.p.project.core.service.contractor;

import pl.lodz.p.project.core.dto.contractor.ContractorContactDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface ContractorContactService {

    List<ContractorContactDTO> getAll();
    
    ContractorContactDTO getOneById(Long id);
    
}
