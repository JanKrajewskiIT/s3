package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.goods.Unit;

/**
 *
 * @author Łukasz, milczu
 */
public interface UnitsManagerLocal {
    
    List<Unit> getUnits();
    
    Unit getById(Long id);
    
    Long add(Unit unit);
    
    void edit(Unit unit);
    
    void remove(Unit unit);
}
