package pl.lodz.p.project.core.domain.document.base;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.lodz.p.project.core.domain.document.warehouse.WarehouseInvoice;
import pl.lodz.p.project.core.domain.good.Good;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Embeddable
public class InvoiceGoodKey<T extends WarehouseInvoice> implements Serializable {

	private static final long serialVersionUID = -800145815758759917L;

	@JoinColumn(name = "invoice_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private T invoice;
	
    @JoinColumn(name = "good_id", referencedColumnName = "good_id", insertable = false, updatable = false)
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
