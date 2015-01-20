package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "id.invoice", cascade = CascadeType.ALL)
	private List<InternalInvoiceGood> invoiceGoodList;

	public List<InternalInvoiceGood> getInvoiceGoodList() {
		return invoiceGoodList;
	}

	public void setInvoiceGoodList(List<InternalInvoiceGood> invoiceGoodList) {
		this.invoiceGoodList = invoiceGoodList;
	}

}
