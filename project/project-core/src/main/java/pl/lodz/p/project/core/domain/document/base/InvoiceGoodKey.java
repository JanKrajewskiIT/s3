package pl.lodz.p.project.core.domain.document.base;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.lodz.p.project.core.domain.document.warehouse.WarehouseInvoice;
import pl.lodz.p.project.core.domain.good.Good;

/**
 * 
 * @author Jan Krajewski
 *s
 */
@Embeddable
public class InvoiceGoodKey<T extends Document> implements Serializable {

	private static final long serialVersionUID = -800145815758759917L;

	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private T invoice;
	
    @JoinColumn(name = "good_id", referencedColumnName = "good_id")
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
