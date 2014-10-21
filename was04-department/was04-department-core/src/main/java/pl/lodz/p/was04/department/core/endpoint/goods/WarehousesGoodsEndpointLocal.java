package pl.lodz.p.was04.department.core.endpoint.goods;

import pl.lodz.p.was04.department.core.domain.goods.WarehouseGoodPK;
import pl.lodz.p.was04.department.core.dto.goods.WarehouseGoodDTO;

/**
 *
 * @author Łukasz
 */
public interface WarehousesGoodsEndpointLocal {

    public WarehouseGoodPK add(WarehouseGoodDTO warehouseGoodDTO);
    
    public boolean isAvailable(Long goodId, Long warehouseId, double quantity);

}
