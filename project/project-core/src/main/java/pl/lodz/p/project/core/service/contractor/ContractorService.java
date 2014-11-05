package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface ContractorService {

    List<ContractorDTO> getAll();

    void delete(Long id);

    void save(ContractorDTO contractorDTO);    

    ContractorDTO getOneById(Long id);
    
    Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest);

}