package pl.lodz.p.project.core.dto.document.warehouse;

import java.io.Serializable;
import java.math.BigDecimal;
import pl.lodz.p.project.core.dto.good.GoodDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class InternalInvoiceGoodDTO implements Serializable, Comparable<InternalInvoiceGoodDTO> {

	private static final long serialVersionUID = -1671475480826805077L;
	
	private GoodDTO good;
	private InternalInvoiceDTO invoice;
    private BigDecimal quantity;
	private Long version;	
        
	public GoodDTO getGood() {
		return good;
	}

	public void setGood(GoodDTO good) {
		this.good = good;
	}

	public InternalInvoiceDTO getInvoice() {
		return invoice;
	}

	public void setInvoice(InternalInvoiceDTO invoice) {
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
	public int compareTo(InternalInvoiceGoodDTO o) {
		return 0;
	}

}
