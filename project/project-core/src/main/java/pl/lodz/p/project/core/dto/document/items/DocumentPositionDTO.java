package pl.lodz.p.project.core.dto.document.items;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.BaseDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.dto.good.TaxDTO;

/**
 *
 * @author Janiu
 */
public class DocumentPositionDTO extends BaseDTO<Long> implements Comparable<DocumentPositionDTO> {

	private static final long serialVersionUID = 1L;

	private String symbol;
    private Double quantity;
    private TaxDTO tax;
    private GoodDTO good;
    private Double priceNet = 0d;
    private Double priceGross = 0d;
    private Double valueNet = 0d;
    private Double valueGross = 0d;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getQuantity() {
		return quantity;
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

	public Double getPriceNet() {
		return priceNet;
	}

	public Double getPriceGross() {
		return priceGross;
	}

	public Double getValueNet() {
		return valueNet;
	}

	public void setValueNet(Double valueNet) {
		this.valueNet = valueNet;
	}

	public Double getValueGross() {
		return valueGross;
	}

	public void setValueGross(Double valueGross) {
		this.valueGross = valueGross;
	}

	public void setQuantity(Double quantity) {
        this.quantity = quantity;
        this.valueNet = priceNet * quantity;
        this.valueGross = priceGross * quantity;
    }

    public void setPriceGross(Double priceGross) {
        this.priceGross = priceGross;
        this.valueGross = priceGross * quantity;
    }
    
    public void setPriceNet(Double priceNet) {
        this.priceNet = priceNet;
        this.valueNet = priceNet * quantity;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(DocumentPositionDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}