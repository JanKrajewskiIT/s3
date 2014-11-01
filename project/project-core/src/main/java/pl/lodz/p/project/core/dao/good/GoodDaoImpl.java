package pl.lodz.p.project.core.dao.good;

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
import pl.lodz.p.project.core.domain.good.Good;

/**
 *
 * @author Milczu, Janiu
 */
@Repository
@Transactional
public class GoodDaoImpl extends AbstractPageableDao<Good, Long> implements GoodDao {

    public GoodDaoImpl() {
        super(Good.class);
    }

	@Override
	@Transactional(readOnly = true)
    public Page<Good> search(String searchQuery, PageRequest pageRequest) {
       return findAll(new GoodSearchSpecification(searchQuery), pageRequest);
    }
}

class GoodSearchSpecification implements Specification<Good> {

    private final String searchQuery;
    
    GoodSearchSpecification(String searchQuery) {
        this.searchQuery = searchQuery;
    }
    
    @Override
    public Predicate toPredicate(Root<Good> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(StringUtils.isBlank(searchQuery)) {
            return cb.isNotNull(root);
        } else {
            return cb.like(cb.upper(root.<String> get("name")), "%" + searchQuery.toUpperCase() + "%");
        }
    }
}
