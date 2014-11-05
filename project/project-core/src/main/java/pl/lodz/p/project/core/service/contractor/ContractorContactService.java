package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import pl.lodz.p.project.core.dto.contractor.ContractorContactDTO;

/**
 *
 * @author Janiu
 */
public interface ContractorContactService {

    List<ContractorContactDTO> getAll();
    
    ContractorContactDTO getOneById(Long id);
    
}
