package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.goods.WarehousesGoodsDao;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGood;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGoodPK;

/**
 *
 * @author Łukasz
 */
@Component
public class WarehousesGoodsManager implements WarehousesGoodsManagerLocal {

    @Autowired
    private WarehousesGoodsDao warehousesGoodsDao;

    @RolesAllowed("goodsManagement")
    @Override
    public WarehouseGood getById(WarehouseGoodPK id) {
        return warehousesGoodsDao.findOne(id);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public List<WarehouseGood> getWarehouseGoods() {
        return warehousesGoodsDao.findAll();
    }

    @RolesAllowed("goodsManagement")
    @Override
    public WarehouseGoodPK add(WarehouseGood warehouseGood) {
        warehousesGoodsDao.save(warehouseGood);
        return warehouseGood.getId();
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void edit(WarehouseGood warehouseGood) {
        WarehouseGood wg = getById(warehouseGood.getId());
        wg.setQuantity(warehouseGood.getQuantity());
        warehousesGoodsDao.save(wg);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void remove(WarehouseGood warehouseGood) {
        warehousesGoodsDao.delete(warehouseGood);
    }
    
    @RolesAllowed("goodsManagement")
    @Override
    public boolean isAvailable(Long goodId, Long warehouseId, double quantity) {
        WarehouseGood warehouseGood = getById(new WarehouseGoodPK(warehouseId, goodId));
        if(warehouseGood.getQuantity() >= quantity) {
            return true;
        } else {
            //TODO not commited 
        	//throw new WarehouseQuantityLimitExceededException(new GoodDTO(warehouseGood.getGood()), warehouseGood.getQuantity());
        	return false;
        }
    }

}
