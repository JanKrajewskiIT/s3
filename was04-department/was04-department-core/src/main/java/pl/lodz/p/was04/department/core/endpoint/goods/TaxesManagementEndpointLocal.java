package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.goods.TaxDTO;

/**
 *
 * @author Łukasz, milczu
 */
public interface TaxesManagementEndpointLocal {

    List<TaxDTO> getTaxes();
    
    TaxDTO getTax(Long id);
    
    Long add(TaxDTO taxDTO);
    
    void edit(TaxDTO taxDTO);
    
    void remove(TaxDTO taxDTO);
}
