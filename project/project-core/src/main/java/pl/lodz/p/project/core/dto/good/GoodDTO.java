package pl.lodz.p.project.core.dto.good;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;
import pl.lodz.p.project.core.enums.GoodType;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Janiu, Łukasz Gadomski
 */
public class GoodDTO extends NamedDTO<Long> implements Comparable<GoodDTO> {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Symbol nie może być pusty!")
	private String symbol;

    private GoodType type = GoodType.GOOD;
    private String pkwiu;   
    private String description;
    private Double weight;
    private UnitDTO unit;
    private TaxDTO tax;
    private GoodGroupDTO group;
	private PricesDTO prices;

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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
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

	public PricesDTO getPrices() {
		return prices;
	}

	public void setPrices(PricesDTO prices) {
		this.prices = prices;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
    public int compareTo(GoodDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
    }

}
