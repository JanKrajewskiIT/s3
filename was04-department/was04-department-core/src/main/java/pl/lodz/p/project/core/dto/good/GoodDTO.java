package pl.lodz.p.project.core.dto.good;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.enums.GoodType;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu, Łukasz Gadomski
 */
public class GoodDTO implements Serializable, Comparable<GoodDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private GoodType type = GoodType.Towar;
    private String pkwiu;   
    private String description;
    private double weight;
    private UnitDTO unit;
    private TaxDTO tax;
    private GoodGroupDTO group;
    
    @NotNull(message = "Symbol nie może być pusty!")
    private String symbol;
    
    @NotNull(message = "Nazwa nie może być pusta!")
    private String name;
    
    @NotNull(message = "Cena A Netto nie może być pusta!")
    private BigDecimal priceANet;
    
    @NotNull(message = "Cena A Brutto nie może być pusta!")
    private BigDecimal priceAGross;
    
    @NotNull(message = "Cena Magazynowa Netto nie może być pusta!")
    private BigDecimal priceMagNet;
    
    @NotNull(message = "Cena Magazynowa  Brutto nie może być pusta!")
    private BigDecimal priceMagGross;

    private BigDecimal priceBNet;
    private BigDecimal priceBGross;
    private BigDecimal priceCNet;
    private BigDecimal priceCGross;
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public UnitDTO getUnit() {
		return unit;
	}

	public void setUnit(UnitDTO unit) {
		this.unit = unit;
	}

	public TaxDTO getTax() {
		return tax;
	}

	public void setTax(TaxDTO tax) {
		this.tax = tax;
	}

	public GoodGroupDTO getGroup() {
		return group;
	}

	public void setGroup(GoodGroupDTO group) {
		this.group = group;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
    public int compareTo(GoodDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
    }

}
