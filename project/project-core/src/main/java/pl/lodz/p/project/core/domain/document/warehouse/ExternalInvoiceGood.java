package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.document.base.InvoiceGood;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * @author Jan Krajewski
 */
@Entity
@Table(name="external_invoices_goods")
public class ExternalInvoiceGood extends InvoiceGood<ExternalInvoice> {

	private static final long serialVersionUID = 1L;

}

