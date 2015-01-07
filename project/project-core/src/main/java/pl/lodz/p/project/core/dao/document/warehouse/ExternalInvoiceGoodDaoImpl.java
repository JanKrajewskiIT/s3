package pl.lodz.p.project.core.dao.document.warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Repository
@Transactional
public class ExternalInvoiceGoodDaoImpl extends AbstractCrudDao<ExternalInvoiceGood, InvoiceGoodKey<ExternalInvoice>> implements ExternalInvoiceGoodDao {

	public ExternalInvoiceGoodDaoImpl() {
		super(ExternalInvoiceGood.class);
	}

}
