package pl.lodz.p.was04.department.core.dao.pagingandsearching;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Milczu
 * @param <T>
 */
public interface Specification<T> {

    /**
     * Creates a WHERE clause for a query of the referenced entity in form of a
     * {@link Predicate} for the given {@link Root} and {@link CriteriaQuery}.
     * 
     * @param root
     * @param query
     * @param cb
     * @return a {@link Predicate}, must not be {@literal null}.
     */
    Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb);
}
