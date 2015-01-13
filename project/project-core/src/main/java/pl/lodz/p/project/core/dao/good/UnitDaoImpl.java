package pl.lodz.p.project.core.dao.good;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.good.Unit;

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
