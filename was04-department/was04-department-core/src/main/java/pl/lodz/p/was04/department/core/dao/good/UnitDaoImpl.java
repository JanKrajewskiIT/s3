package pl.lodz.p.was04.department.core.dao.good;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.good.Unit;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class UnitDaoImpl extends AbstractCrudDao<Unit, Long> implements UnitDao {

    public UnitDaoImpl() {
        super(Unit.class);
    }
    
}
