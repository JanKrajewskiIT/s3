package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;

/**
 *
 * @author Janiu
 */
public interface ContractorsManagementEndpointLocal {

    List<ContractorDTO> getAllContractors();

    void removeContractor(Long id);

    void addContractor(ContractorDTO contractorDTO);
    
    void editContractor(ContractorDTO contractorDTO);

    ContractorDTO findById(Long id);
    
    Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest);

}
