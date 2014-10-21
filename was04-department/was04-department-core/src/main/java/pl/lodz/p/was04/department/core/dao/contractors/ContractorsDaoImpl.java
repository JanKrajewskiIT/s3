package pl.lodz.p.was04.department.core.dao.contractors;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.AbstractPageableDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Specification;
import pl.lodz.p.was04.department.core.domain.contractors.Contractor;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class ContractorsDaoImpl extends AbstractPageableDao<Contractor, Long> implements ContractorsDao {

    private CriteriaBuilder cb;

    public ContractorsDaoImpl() {
        super(Contractor.class);
    }

	@Override
	@Transactional(readOnly = true)
    public void removeById(Long id) {
        this.cb = getEntityManager().getCriteriaBuilder();
        /* TODO CriteriaDelete<Contractor> delete = cb.createCriteriaDelete(Contractor.class);
        Root<Contractor> e = delete.from(Contractor.class);
        delete.where(cb.equal(e.get("id"), id));
        Query query = getEntityManager().createQuery(delete);
        query.executeUpdate();*/
    }

	@Override
	@Transactional(readOnly = true)
    public void saveContractor(Contractor contractor, boolean edit) {
        try {
            if (edit) {
                getEntityManager().merge(contractor);
            } else {
                getEntityManager().persist(contractor);
            }
        } catch (javax.validation.ConstraintViolationException cve) {
            Set<ConstraintViolation<?>> cvs = cve.getConstraintViolations();

            for (ConstraintViolation<?> cv : cvs) {
                System.out.println(cv.getMessage());
            }
        }
    }

	@Override
	@Transactional(readOnly = true)
    public Page<Contractor> search(String searchQuery, PageRequest pageRequest) {
        return findAll(new ContractorsSearchSpecification(searchQuery), pageRequest);
    }

}

class ContractorsSearchSpecification implements Specification<Contractor> {

    private final String searchQuery;
    
    ContractorsSearchSpecification(String searchQuery) {
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
