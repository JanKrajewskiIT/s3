package pl.lodz.p.was04.department.core.dto.document;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.dto.good.GoodDTO;
import pl.lodz.p.was04.department.core.dto.good.TaxDTO;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu
 */
public class DocumentPositionDTO implements Serializable, Comparable<DocumentPositionDTO> {

	private static final long serialVersionUID = 1L;
	
    private Long id;
	private String symbol;
    private Double quantity;
    private TaxDTO tax;
    private GoodDTO good;
    private BigDecimal priceNet = BigDecimal.ZERO;
    private BigDecimal priceGross = BigDecimal.ZERO;
    private BigDecimal valueNet = BigDecimal.ZERO;
    private BigDecimal valueGross = BigDecimal.ZERO;
    
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

	public TaxDTO getTax() {
		return tax;
	}

	public void setTax(TaxDTO tax) {
		this.tax = tax;
	}

	public GoodDTO getGood() {
		return good;
	}

	public void setGood(GoodDTO good) {
		this.good = good;
	}

	public BigDecimal getValueNet() {
		return valueNet;
	}

	public void setValueNet(BigDecimal valueNet) {
		this.valueNet = valueNet;
	}

	public BigDecimal getValueGross() {
		return valueGross;
	}

	public void setValueGross(BigDecimal valueGross) {
		this.valueGross = valueGross;
	}

	public BigDecimal getPriceNet() {
		return priceNet;
	}

	public BigDecimal getPriceGross() {
		return priceGross;
	}

	public void setQuantity(double quantity) {
        this.quantity = quantity;
        this.valueNet = priceNet.multiply(BigDecimal.valueOf(quantity));
        this.valueGross = priceGross.multiply(BigDecimal.valueOf(quantity));
    }

    public void setPriceGross(BigDecimal priceGross) {
        this.priceGross = priceGross;
        this.valueGross = priceGross.multiply(BigDecimal.valueOf(quantity));
    }
    
    public void setPriceNet(BigDecimal priceNet) {
        this.priceNet = priceNet;
        this.valueNet = priceNet.multiply(BigDecimal.valueOf(quantity));
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(DocumentPositionDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}

}
