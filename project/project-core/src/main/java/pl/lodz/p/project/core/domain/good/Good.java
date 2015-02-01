package pl.lodz.p.project.core.domain.good;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.base.NamedEntity;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.enums.GoodType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "goods")
public class Good extends NamedEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "symbol")
    private String symbol;

    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private GoodType type;
    
    @Size(min = 0, max = 25)
    @Column(name = "pkwiu")
    private String pkwiu;

	@Embedded
	private Prices prices;
    
    @Basic(optional = true)
    @Column(name = "description")
    @Size(min = 0, max = 2147483647)
    private String description;
    
    @Basic(optional = true)
    @Column(name = "weight")
    private Double weight;
    
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unit unit;
    
    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tax tax;
    
    @JoinColumn(name = "good_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodGroup group;

	@NotNull
	@Column(name = "quantity")
	private Double quantity;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}

	public String getPkwiu() {
		return pkwiu;
	}

	public void setPkwiu(String pkwiu) {
		this.pkwiu = pkwiu;
	}

	public Prices getPrices() {
		return prices;
	}

	public void setPrices(Prices prices) {
		this.prices = prices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public GoodGroup getGroup() {
		return group;
	}

	public void setGroup(GoodGroup group) {
		this.group = group;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
