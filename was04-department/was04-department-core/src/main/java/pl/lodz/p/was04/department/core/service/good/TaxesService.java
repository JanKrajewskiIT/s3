package pl.lodz.p.was04.department.core.service.good;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.good.TaxDTO;

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
