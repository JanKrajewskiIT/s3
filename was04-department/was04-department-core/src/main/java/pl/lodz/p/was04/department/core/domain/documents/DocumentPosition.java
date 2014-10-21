package pl.lodz.p.was04.department.core.domain.documents;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Persistable;

import pl.lodz.p.was04.department.core.domain.goods.Good;
import pl.lodz.p.was04.department.core.domain.goods.Tax;
import pl.lodz.p.was04.department.core.dto.documents.DocumentPositionDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "documents_positions")
@XmlRootElement
public class DocumentPosition implements Serializable, Persistable<DocumentPositionPK> {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentPositionPK id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private double quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_net")
    private BigDecimal priceNet;
    @Version
    private long version;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouses;
    @JoinColumn(name = "tax_id", referencedColumnName = "tax_id")
    @ManyToOne(optional = false)
    private Tax tax;
    @JoinColumn(name = "good_id", referencedColumnName = "good_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Good good;

    public DocumentPosition() {
    }

    public DocumentPosition(DocumentPositionPK id) {
        this.id = id;
    }

    public DocumentPosition(DocumentPositionPK id, double quantity, BigDecimal priceNet, long version) {
        this.id = id;
        this.quantity = quantity;
        this.priceNet = priceNet;
        this.version = version;
    }

    public DocumentPosition(String documentSymbol, Long goodId, Long warehouseId) {
        this.id = new DocumentPositionPK(documentSymbol, goodId, warehouseId);
    }

    public DocumentPosition(DocumentPositionDTO documentPositionDTO) {
        this.id = new DocumentPositionPK(documentPositionDTO.getSymbol(), documentPositionDTO.getGood().getId(), documentPositionDTO.getWarehouse().getId());
        this.good = new Good(documentPositionDTO.getGood());
        this.priceNet = documentPositionDTO.getPriceNet();
        this.quantity = documentPositionDTO.getQuantity();
        this.tax = new Tax(documentPositionDTO.getTax());
        this.warehouses = new Warehouse(documentPositionDTO.getWarehouse());
    }

    @Override
    public DocumentPositionPK getId() {
        return id;
    }

    public void setId(DocumentPositionPK id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceNet() {
        return priceNet;
    }

    public void setPriceNet(BigDecimal priceNet) {
        this.priceNet = priceNet;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Warehouse getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Warehouse warehouses) {
        this.warehouses = warehouses;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentPosition)) {
            return false;
        }
        DocumentPosition other = (DocumentPosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
