package pl.lodz.p.was04.department.core.domain.goods;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.domain.Persistable;

import pl.lodz.p.was04.department.core.domain.documents.Warehouse;
import pl.lodz.p.was04.department.core.dto.goods.WarehouseGoodDTO;

/**
 *
 * @author Łukasz
 */
@Entity
@Table(name = "warehouses_goods")
@XmlRootElement
public class WarehouseGood implements Serializable, Persistable<WarehouseGoodPK> {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WarehouseGoodPK id;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "is_active")
    private boolean active;
    @Version
    private Long version = 1L;
    @JoinColumn(name = "warehouse", referencedColumnName = "warehouse_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouse;
    @JoinColumn(name = "good", referencedColumnName = "good_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Good good;

    public WarehouseGood() {
    }

    public WarehouseGood(WarehouseGoodDTO warehouseGood) {
        this.id = new WarehouseGoodPK(warehouseGood.getWarehouseId().getId(), warehouseGood.getGoodId().getId());
        this.good = new Good(warehouseGood.getGoodId());
        this.warehouse = new Warehouse(warehouseGood.getWarehouseId());
        this.quantity = warehouseGood.getQuantity();
        this.version = warehouseGood.getVersion();
        this.active = warehouseGood.isActive();
    }

    public WarehouseGood(WarehouseGoodPK warehousesGoodsPK) {
        this.id = warehousesGoodsPK;
    }

    public WarehouseGood(Long warehouse, Long good) {
        this.id = new WarehouseGoodPK(warehouse, good);
    }

    @Override
    public WarehouseGoodPK getId() {
        return id;
    }

    public void setId(WarehouseGoodPK id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
    
    public double invokeWarehouseResult(double diff) {
        quantity += diff;
        return quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof WarehouseGood)) {
            return false;
        }
        WarehouseGood other = (WarehouseGood) object;
        return new EqualsBuilder().append(id, other.id).build();
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.goods.WarehouseGood[ warehouseGoodPK=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
