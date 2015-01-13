package pl.lodz.p.project.core.dao.document.warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Repository
@Transactional
public class InternalInvoiceDaoImpl extends AbstractCrudDao<InternalInvoice, Long> implements InternalInvoiceDao {

	public InternalInvoiceDaoImpl() {
		super(InternalInvoice.class);
	}

}
