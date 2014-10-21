package pl.lodz.p.was04.department.core.dao.goods;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.goods.GoodGroup;

/**
 *
 * @author Łukasz
 */
@Repository
@Transactional
public class GoodsGroupsDaoImpl extends AbstractCrudDao<GoodGroup, Long> implements GoodsGroupsDao {

    public GoodsGroupsDaoImpl() {
        super(GoodGroup.class);
    }
    
}
