package pl.lodz.p.project.core.dao.good;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.good.GoodGroup;

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
