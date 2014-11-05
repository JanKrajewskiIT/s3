package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dto.good.TaxDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface TaxService {

    List<TaxDTO> getAll();
    
    TaxDTO getOneById(Long id);
        
    void save(TaxDTO taxDTO);
    
    void delete(TaxDTO taxDTO);
    
}
