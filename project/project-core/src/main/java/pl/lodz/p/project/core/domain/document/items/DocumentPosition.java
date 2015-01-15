package pl.lodz.p.project.core.domain.document.items;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.base.BaseEntity;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.domain.good.Tax;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "documents_positions")
public class DocumentPosition extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

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
    private Double priceNet;

    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    @ManyToOne(optional = false)    
    private Tax tax;
    
    @JoinColumn(name = "good_id", referencedColumnName = "id")
    @ManyToOne(optional = false)    
    private Good good;

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

	public Double getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(Double priceNet) {
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

}
