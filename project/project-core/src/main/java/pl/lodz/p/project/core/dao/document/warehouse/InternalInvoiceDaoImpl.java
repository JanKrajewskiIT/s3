package pl.lodz.p.project.core.dao.document.warehouse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.pagingandsearching.AbstractPageableDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Specification;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Jan Krajewski
 */
@Repository
@Transactional
public class InternalInvoiceDaoImpl extends AbstractPageableDao<InternalInvoice, Long> implements InternalInvoiceDao {

	public InternalInvoiceDaoImpl() {
		super(InternalInvoice.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<InternalInvoice> search(String searchQuery, PageRequest pageRequest) {
		return findAll(new InvoiceSearchSpecification(searchQuery), pageRequest);
	}

	public void updateQuantity(Long id, Double quantity) {
		String queryValue = "UPDATE Good good SET good.quantity = :quantity WHERE good.id = :id";
		Query query = getEntityManager().createQuery(queryValue);
		query.setParameter("quantity", quantity).setParameter("id", id).executeUpdate();
	}

	class InvoiceSearchSpecification implements Specification<InternalInvoice> {

		private final String searchQuery;

		InvoiceSearchSpecification(String searchQuery) {
			this.searchQuery = searchQuery;
		}

		@Override
		public Predicate toPredicate(Root<InternalInvoice> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			if (StringUtils.isBlank(searchQuery)) {
				return cb.isNotNull(root);
			} else {
				return cb.like(cb.upper(root.<String>get("symbol")), "%" + searchQuery.toUpperCase() + "%");
			}
		}
	}

}