package pl.lodz.p.project.core.dao.document.warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Repository
@Transactional
public class ExternalInvoiceDaoImpl extends AbstractCrudDao<ExternalInvoice, Long> implements ExternalInvoiceDao {

	public ExternalInvoiceDaoImpl() {
		super(ExternalInvoice.class);
	}

}
