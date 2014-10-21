package pl.lodz.p.was04.department.core.domain.goods;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Łukasz
 */
@Embeddable
public class WarehouseGoodPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "warehouse")
    private Long warehouse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "good")
    private Long good;

    public WarehouseGoodPK() {
    }

    public WarehouseGoodPK(Long warehouse, Long good) {
        this.warehouse = warehouse;
        this.good = good;
    }

    public Long getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Long warehouse) {
        this.warehouse = warehouse;
    }

    public Long getGood() {
        return good;
    }

    public void setGood(Long good) {
        this.good = good;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warehouse != null ? warehouse.hashCode() : 0);
        hash += (good != null ? good.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarehouseGoodPK)) {
            return false;
        }
        WarehouseGoodPK other = (WarehouseGoodPK) object;
        if ((this.warehouse == null && other.warehouse != null) || (this.warehouse != null && !this.warehouse.equals(other.warehouse))) {
            return false;
        }
        if ((this.good == null && other.good != null) || (this.good != null && !this.good.equals(other.good))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.goods.WarehousesGoodsPK[ warehouse=" + warehouse + ", good=" + good + " ]";
    }

}
