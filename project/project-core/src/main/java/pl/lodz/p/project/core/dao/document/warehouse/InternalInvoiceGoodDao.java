package pl.lodz.p.project.core.dao.document.warehouse;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface InternalInvoiceGoodDao extends CrudDao<InternalInvoiceGood, InvoiceGoodKey<InternalInvoice>> {

}
