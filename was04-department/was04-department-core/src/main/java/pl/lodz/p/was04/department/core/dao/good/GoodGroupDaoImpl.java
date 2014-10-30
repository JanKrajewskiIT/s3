package pl.lodz.p.was04.department.core.dao.good;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.good.GoodGroup;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class GoodGroupDaoImpl extends AbstractCrudDao<GoodGroup, Long> implements GoodGroupDao {

    public GoodGroupDaoImpl() {
        super(GoodGroup.class);
    }
    
}
