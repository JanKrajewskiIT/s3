package pl.lodz.p.project.core.domain.good;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import pl.lodz.p.project.core.domain.base.Activable;
import pl.lodz.p.project.core.enums.GoodType;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "goods")
public class Good implements Serializable, Activable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "symbol")
    private String symbol;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private GoodType type;
    
    @Size(min = 0, max = 25)
    @Column(name = "pkwiu")
    private String pkwiu;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_a_net")
    private BigDecimal priceANet;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_a_gross")
    private BigDecimal priceAGross;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_mag_net")
    private BigDecimal priceMagNet;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_mag_gross")
    private BigDecimal priceMagGross;
    
    @Basic(optional = true)
    @Column(name = "price_b_net")
    private BigDecimal priceBNet;
    
    @Basic(optional = true)
    @Column(name = "price_b_gross")
    private BigDecimal priceBGross;
    
    @Basic(optional = true)
    @Column(name = "price_c_net")
    private BigDecimal priceCNet;
    
    @Basic(optional = true)
    @Column(name = "price_c_gross")
    private BigDecimal priceCGross;
    
    @Basic(optional = true)
    @Column(name = "description")
    @Size(min = 0, max = 2147483647)
    private String description;
    
    @Basic(optional = true)
    @Column(name = "weight")
    private Double weight;
    
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    @ManyToOne(optional = false)
    private Unit unit;
    
    @JoinColumn(name = "tax_id", referencedColumnName = "tax_id")
    @ManyToOne(optional = false)
    private Tax tax;
    
    @JoinColumn(name = "good_group_id", referencedColumnName = "good_group_id")
    @ManyToOne(optional = false)
    private GoodGroup group;

    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active = true;
    
    @Version
    private Long version = 1L;
            
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public BigDecimal getPriceANet() {
		return priceANet;
	}

	public void setPriceANet(BigDecimal priceANet) {
		this.priceANet = priceANet;
	}

	public BigDecimal getPriceAGross() {
		return priceAGross;
	}

	public void setPriceAGross(BigDecimal priceAGross) {
		this.priceAGross = priceAGross;
	}

	public BigDecimal getPriceMagNet() {
		return priceMagNet;
	}

	public void setPriceMagNet(BigDecimal priceMagNet) {
		this.priceMagNet = priceMagNet;
	}

	public BigDecimal getPriceMagGross() {
		return priceMagGross;
	}

	public void setPriceMagGross(BigDecimal priceMagGross) {
		this.priceMagGross = priceMagGross;
	}

	public BigDecimal getPriceBNet() {
		return priceBNet;
	}

	public void setPriceBNet(BigDecimal priceBNet) {
		this.priceBNet = priceBNet;
	}

	public BigDecimal getPriceBGross() {
		return priceBGross;
	}

	public void setPriceBGross(BigDecimal priceBGross) {
		this.priceBGross = priceBGross;
	}

	public BigDecimal getPriceCNet() {
		return priceCNet;
	}

	public void setPriceCNet(BigDecimal priceCNet) {
		this.priceCNet = priceCNet;
	}

	public BigDecimal getPriceCGross() {
		return priceCGross;
	}

	public void setPriceCGross(BigDecimal priceCGross) {
		this.priceCGross = priceCGross;
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
