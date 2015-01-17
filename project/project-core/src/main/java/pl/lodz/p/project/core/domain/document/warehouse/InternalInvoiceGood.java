package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.document.base.InvoiceGood;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices_goods")
public class InternalInvoiceGood extends InvoiceGood<InternalInvoice, Long> {

	private static final long serialVersionUID = 1L;

}
