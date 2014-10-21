package pl.lodz.p.was04.department.core.dao.goods;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGood;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGoodPK;

/**
 *
 * @author Łukasz
 */
@Repository
@Transactional
public class WarehousesGoodsDaoImpl extends AbstractCrudDao<WarehouseGood, WarehouseGoodPK> implements WarehousesGoodsDao {

    public WarehousesGoodsDaoImpl() {
        super(WarehouseGood.class);
    }
    
}
