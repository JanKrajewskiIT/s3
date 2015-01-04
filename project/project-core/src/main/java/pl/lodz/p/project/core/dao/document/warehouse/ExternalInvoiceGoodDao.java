package pl.lodz.p.project.core.dao.document.warehouse;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.domain.document.warehouse.InvoiceGoodKey;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface ExternalInvoiceGoodDao extends CrudDao<ExternalInvoiceGood, InvoiceGoodKey<ExternalInvoice>> {

}
