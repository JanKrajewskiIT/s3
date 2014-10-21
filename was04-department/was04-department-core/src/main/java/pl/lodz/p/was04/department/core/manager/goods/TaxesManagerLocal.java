package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.goods.Tax;

/**
 *
 * @author Łukasz, milczu
 */
public interface TaxesManagerLocal {

    Tax getById(Long id);

    List<Tax> getTaxes();
    
    Long add(Tax tax);
    
    void edit(Tax tax);
    
    void remove(Tax tax);
}
