package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.Entity;
import javax.persistence.Table;

import pl.lodz.p.project.core.domain.document.base.Document;
import pl.lodz.p.project.core.domain.document.base.InvoiceGood;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Entity
@Table(name = "internal_invoices_goods")
public class InternalInvoiceGood extends InvoiceGood<InvoiceGoodKey<InternalInvoice>> {

	private static final long serialVersionUID = 4953126124258975050L;
	
}
