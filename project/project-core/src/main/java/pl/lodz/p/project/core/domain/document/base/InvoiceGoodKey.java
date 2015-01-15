package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.good.Good;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Embeddable
public class InvoiceGoodKey<T extends Document> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private T invoice;
	
    @JoinColumn(name = "good_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Good good;    
    
	public T getInvoice() {
		return invoice;
	}

	public void setInvoice(T invoice) {
		this.invoice = invoice;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

}
