package pl.lodz.p.project.core.dao.document.warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Repository
@Transactional
public class ExternalInvoiceGoodDaoImpl extends AbstractCrudDao<ExternalInvoiceGood, Long> implements ExternalInvoiceGoodDao {

	public ExternalInvoiceGoodDaoImpl() {
		super(ExternalInvoiceGood.class);
	}

	@Override
	public List<ExternalInvoiceGoodDTO> getGoodsByInvoice(Long id) {
		return entityManager.createQuery("from " + ExternalInvoiceGood.class.getName()).getResultList();
	}
}
