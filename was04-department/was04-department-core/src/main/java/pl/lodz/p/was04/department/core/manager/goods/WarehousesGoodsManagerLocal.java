package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.goods.WarehouseGood;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGoodPK;

/**
 *
 * @author Łukasz
 */
public interface WarehousesGoodsManagerLocal {

    public WarehouseGood getById(WarehouseGoodPK id);

    public List<WarehouseGood> getWarehouseGoods();

    public WarehouseGoodPK add(WarehouseGood warehouseGood);

    public void edit(WarehouseGood warehouseGood);

    public void remove(WarehouseGood warehouseGood);
    
    boolean isAvailable(Long goodId, Long warehouseId, double quantity);
}
