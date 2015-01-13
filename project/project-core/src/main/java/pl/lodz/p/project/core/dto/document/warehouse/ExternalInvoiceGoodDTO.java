package pl.lodz.p.project.core.dto.document.warehouse;

import java.io.Serializable;
import java.math.BigDecimal;
import pl.lodz.p.project.core.dto.good.GoodDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class ExternalInvoiceGoodDTO implements Serializable, Comparable<ExternalInvoiceGoodDTO> {

	private static final long serialVersionUID = -1671475480826805077L;
	
	private GoodDTO good;
	private ExternalInvoiceDTO invoice;
    private BigDecimal quantity;
	private Long version;	
        
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int compareTo(ExternalInvoiceGoodDTO o) {
		return 0;
	}

}
