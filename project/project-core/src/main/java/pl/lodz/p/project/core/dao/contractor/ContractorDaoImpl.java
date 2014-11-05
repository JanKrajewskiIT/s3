package pl.lodz.p.project.core.dao.contractor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.pagingandsearching.AbstractPageableDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Specification;
import pl.lodz.p.project.core.domain.contractor.Contractor;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class ContractorDaoImpl extends AbstractPageableDao<Contractor, Long> implements ContractorDao {

    private CriteriaBuilder cb;

    public ContractorDaoImpl() {
        super(Contractor.class);
    }

	@Override
	@Transactional(readOnly = true)
    public void remove(Long id) {
        this.cb = getEntityManager().getCriteriaBuilder();
        /* TODO CriteriaDelete<Contractor> delete = cb.createCriteriaDelete(Contractor.class);
        Root<Contractor> e = delete.from(Contractor.class);
        delete.where(cb.equal(e.get("id"), id));
        Query query = getEntityManager().createQuery(delete);
        query.executeUpdate();*/
    }

	@Override
	@Transactional(readOnly = true)
    public Page<Contractor> search(String searchQuery, PageRequest pageRequest) {
        return findAll(new ContractorSearchSpecification(searchQuery), pageRequest);
    }

}

class ContractorSearchSpecification implements Specification<Contractor> {

    private final String searchQuery;
    
    ContractorSearchSpecification(String searchQuery) {
        this.searchQuery = searchQuery;
    }
    
    @Override
    public Predicate toPredicate(Root<Contractor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(StringUtils.isBlank(searchQuery)) {
            return cb.isNotNull(root);
        } else {
            return cb.like(cb.upper(root.<String> get("name")), "%" + searchQuery.toUpperCase() + "%");
        }
    }
}
