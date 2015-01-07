package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.document.base.InvoiceGood;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Entity
@Table(name = "external_invoices_goods")
public class ExternalInvoiceGood extends InvoiceGood<InvoiceGoodKey<ExternalInvoice>> {

	private static final long serialVersionUID = 4953126124258975050L;

}
