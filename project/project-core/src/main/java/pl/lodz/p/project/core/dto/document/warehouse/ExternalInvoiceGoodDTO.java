package pl.lodz.p.project.core.dto.document.warehouse;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.BaseDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class ExternalInvoiceGoodDTO extends BaseDTO<Long> implements Comparable<ExternalInvoiceGoodDTO> {

	private static final long serialVersionUID = 1L;
	
	private GoodDTO good;
	private ExternalInvoiceDTO invoice;
    private Double quantity;
        
	public GoodDTO getGood() {
		return good;
	}

	public void setGood(GoodDTO good) {
		this.good = good;
	}

	public ExternalInvoiceDTO getInvoice() {
		return invoice;
	}

	public void setInvoice(ExternalInvoiceDTO invoice) {
		this.invoice = invoice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public int compareTo(ExternalInvoiceGoodDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
}
