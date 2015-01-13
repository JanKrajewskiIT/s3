package pl.lodz.p.project.core.domain.document.items;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.domain.base.BasePersistable;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.domain.good.Tax;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "documents_positions")
public class DocumentPosition implements Serializable, BasePersistable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_position_id")    
    protected Long id;
    
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "symbol")
    private String symbol;
        
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private Double quantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_net")
    private BigDecimal priceNet;

    @JoinColumn(name = "tax_id", referencedColumnName = "tax_id")
    @ManyToOne(optional = false)    
    private Tax tax;
    
    @JoinColumn(name = "good_id", referencedColumnName = "good_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)    
    private Good good;
    
    @Version
    private long version;
        
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(BigDecimal priceNet) {
		this.priceNet = priceNet;
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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public boolean isNew() {
		return id == null;
	}

}
