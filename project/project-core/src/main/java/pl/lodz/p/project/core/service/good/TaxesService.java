package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dto.good.TaxDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface TaxesService {

    List<TaxDTO> getTaxes();
    
    TaxDTO getTax(Long id);
    
    Long add(TaxDTO taxDTO);
    
    void edit(TaxDTO taxDTO);
    
    void remove(TaxDTO taxDTO);
}
