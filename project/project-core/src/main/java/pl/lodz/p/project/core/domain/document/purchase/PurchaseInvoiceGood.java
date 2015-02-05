package pl.lodz.p.project.core.domain.document.purchase;

import pl.lodz.p.project.core.domain.document.base.InvoiceGood;
import pl.lodz.p.project.core.domain.good.Tax;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "purchase_invoices_goods")
public class PurchaseInvoiceGood extends InvoiceGood<PurchaseInvoice> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price_net")
    private Double priceNet;

    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tax tax;


	public Double getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(Double priceNet) {
		this.priceNet = priceNet;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}
}
