package pl.lodz.p.project.core.dao.document.warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Repository
@Transactional
public class InternalInvoiceGoodDaoImpl extends AbstractCrudDao<InternalInvoiceGood, Long> implements InternalInvoiceGoodDao {

	public InternalInvoiceGoodDaoImpl() {
		super(InternalInvoiceGood.class);
	}

	@Override
	public List<InternalInvoiceGoodDTO> getGoodsByInvoice(Long id) {
		return entityManager.createQuery("from " + InternalInvoiceGood.class.getName()).getResultList();
	}
}
