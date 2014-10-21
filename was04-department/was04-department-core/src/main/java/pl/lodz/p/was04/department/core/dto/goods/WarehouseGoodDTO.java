package pl.lodz.p.was04.department.core.dto.goods;

import java.io.Serializable;

import pl.lodz.p.was04.department.core.domain.goods.WarehouseGood;
import pl.lodz.p.was04.department.core.dto.documents.WarehouseDTO;

/**
 *
 * @author Łukasz
 */
public class WarehouseGoodDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private GoodDTO goodId;
    private WarehouseDTO warehouseId;
    private Double quantity;
    private boolean active;
    private Long version;

    public WarehouseGoodDTO() {
    }

    public WarehouseGoodDTO(GoodDTO goodId, WarehouseDTO warehouseId, Double quantity, boolean active, Long version) {
        this.goodId = goodId;
        this.warehouseId = warehouseId;
        this.quantity = quantity;
        this.active = active;
        this.version = version;
    }

    public WarehouseGoodDTO(WarehouseGood warehouseGood) {
        this.goodId = new GoodDTO(warehouseGood.getGood());
        this.warehouseId = new WarehouseDTO(warehouseGood.getWarehouse());
        this.quantity = warehouseGood.getQuantity();
        this.active = warehouseGood.isActive();
        this.version = warehouseGood.getVersion();
    }

    /**
     * @return the goodId
     */
    public GoodDTO getGoodId() {
        return goodId;
    }

    /**
     * @param goodId the goodId to set
     */
    public void setGoodId(GoodDTO goodId) {
        this.goodId = goodId;
    }

    /**
     * @return the warehouseId
     */
    public WarehouseDTO getWarehouseId() {
        return warehouseId;
    }

    /**
     * @param warehouseId the warehouseId to set
     */
    public void setWarehouseId(WarehouseDTO warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * @return the quantity
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the isActive
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}
