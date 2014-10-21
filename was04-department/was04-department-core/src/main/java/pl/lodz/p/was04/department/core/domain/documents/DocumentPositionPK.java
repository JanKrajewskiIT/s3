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
public class DocumentPositionPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "document_symbol")
    private String documentSymbol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "good_id")
    private Long goodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "warehouse_id")
    private Long warehouseId;

    public DocumentPositionPK() {
    }

    public DocumentPositionPK(String documentSymbol, Long goodId, Long warehouseId) {
        this.documentSymbol = documentSymbol;
        this.goodId = goodId;
        this.warehouseId = warehouseId;
    }

    public String getDocumentSymbol() {
        return documentSymbol;
    }

    public void setDocumentSymbol(String documentSymbol) {
        this.documentSymbol = documentSymbol;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
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
        hash += (documentSymbol != null ? documentSymbol.hashCode() : 0);
        hash += (goodId != null ? goodId.hashCode() : 0);
        hash += (warehouseId != null ? warehouseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentPositionPK)) {
            return false;
        }
        DocumentPositionPK other = (DocumentPositionPK) object;
        if ((this.documentSymbol == null && other.documentSymbol != null) || (this.documentSymbol != null && !this.documentSymbol.equals(other.documentSymbol))) {
            return false;
        }
        if ((this.goodId == null && other.goodId != null) || (this.goodId != null && !this.goodId.equals(other.goodId))) {
            return false;
        }
        if ((this.warehouseId == null && other.warehouseId != null) || (this.warehouseId != null && !this.warehouseId.equals(other.warehouseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.DocumentsPositionsPK[ documentSymbol=" + documentSymbol + ", goodId=" + goodId + ", warehouseId=" + warehouseId + " ]";
    }
    
}
