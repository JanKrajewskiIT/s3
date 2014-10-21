package pl.lodz.p.was04.department.core.domain.documents;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author janiu
 */
@Embeddable
public class WarehouseDocumentPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "symbol")
    private String symbol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "warehouse_id")
    private Long warehouseId;

    public WarehouseDocumentPK() {
    }

    public WarehouseDocumentPK(String symbol, Long warehouseId) {
        this.symbol = symbol;
        this.warehouseId = warehouseId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (symbol != null ? symbol.hashCode() : 0);
        hash += (warehouseId != null ? warehouseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarehouseDocumentPK)) {
            return false;
        }
        WarehouseDocumentPK other = (WarehouseDocumentPK) object;
        if ((this.symbol == null && other.symbol != null) || (this.symbol != null && !this.symbol.equals(other.symbol))) {
            return false;
        }
        if ((this.warehouseId == null && other.warehouseId != null) || (this.warehouseId != null && !this.warehouseId.equals(other.warehouseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.WarehouseDocumentsPK[ symbol=" + symbol + ", warehouseId=" + warehouseId + " ]";
    }
    
}
