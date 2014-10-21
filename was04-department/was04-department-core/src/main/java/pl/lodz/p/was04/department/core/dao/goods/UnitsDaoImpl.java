package pl.lodz.p.was04.department.core.dao.goods;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.goods.Unit;

/**
 *
 * @author Łukasz
 */
@Repository
@Transactional
public class UnitsDaoImpl extends AbstractCrudDao<Unit, Long> implements UnitsDao {

    public UnitsDaoImpl() {
        super(Unit.class);
    }
    
}
