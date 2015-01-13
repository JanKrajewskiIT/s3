package pl.lodz.p.project.core.dao.document.warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Repository
@Transactional
public class InternalInvoiceGoodDaoImpl extends AbstractCrudDao<InternalInvoiceGood, InvoiceGoodKey<InternalInvoice>> implements InternalInvoiceGoodDao {

	public InternalInvoiceGoodDaoImpl() {
		super(InternalInvoiceGood.class);
	}

}
