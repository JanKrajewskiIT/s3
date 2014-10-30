package pl.lodz.p.was04.department.core.service.contractor;

import java.util.List;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface ContractorsService {

    List<ContractorDTO> getAllContractors();

    void removeContractor(Long id);

    void addContractor(ContractorDTO contractorDTO);
    
    void editContractor(ContractorDTO contractorDTO);

    ContractorDTO findById(Long id);
    
    Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest);

}
