package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "id.invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<InternalInvoiceGood> invoiceGoodList;

	public Set<InternalInvoiceGood> getInvoiceGoodList() {
		return invoiceGoodList;
	}

	public void setInvoiceGoodList(Set<InternalInvoiceGood> invoiceGoodList) {
		this.invoiceGoodList = invoiceGoodList;
	}

}
