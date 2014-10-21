package pl.lodz.p.was04.department.core.endpoint.goods;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.goods.WarehouseGood;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGoodPK;
import pl.lodz.p.was04.department.core.dto.goods.WarehouseGoodDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.goods.WarehousesGoodsManagerLocal;

/**
 *
 * @author Łukasz
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class WarehousesGoodsEndpoint implements WarehousesGoodsEndpointLocal {

    @Autowired
    WarehousesGoodsManagerLocal warehousesGoodsManagerLocal;
    
    /* TODO not even used
    private List<WarehouseGoodDTO> createUnitsDTOList(List<WarehouseGood> listOfEnties) {
        List<WarehouoseGoodDTO> warehouseGoodDTO = new ArrayList<>();
        for (int i = 0; i < listOfEnties.size(); i++) {
            warehouseGoodDTO.add(new WarehouseGoodDTO(listOfEnties.get(i)));
        }
        return warehouseGoodDTO;
    }*/

    @RolesAllowed("goodsManagement")
    @Override
    public WarehouseGoodPK add(WarehouseGoodDTO warehouseGoodDTO) {
        return warehousesGoodsManagerLocal.add(new WarehouseGood(warehouseGoodDTO));
    }
    
    @Override
    public boolean isAvailable(Long goodId, Long warehouseId, double quantity) {
        return warehousesGoodsManagerLocal.isAvailable(goodId, warehouseId, quantity);
    }
}
