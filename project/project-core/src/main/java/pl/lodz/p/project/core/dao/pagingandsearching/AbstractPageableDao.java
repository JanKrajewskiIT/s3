package pl.lodz.p.project.core.dao.pagingandsearching;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Sort.Order;
import pl.lodz.p.project.core.util.Assert;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milczu
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractPageableDao<T extends Persistable<ID>, ID extends Serializable> extends AbstractCrudDao<T, ID> implements JpaSpecificationExecutor<T> {

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given
     * domain type.
     * 
     * @param domainClass
     */
    public AbstractPageableDao(Class<T> domainClass) {
        super(domainClass);
    }


    @Override
    public T findOne(Specification<T> spec) {
        try {
            return getQuery(spec, (Sort) null).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> findAll(Specification<T> spec) {

        return getQuery(spec, (Sort) null).getResultList();
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        TypedQuery<T> query = getQuery(spec, pageable);
        return pageable == null ? new PageImpl<>(query.getResultList()) : readPage(query, pageable, spec);
    }

    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return getQuery(spec, sort).getResultList();
    }

    @Override
    public long count(Specification<T> spec) {
        return getCountQuery(spec).getSingleResult();
    }

    /**
     * Reads the given {@link TypedQuery} into a {@link Page} applying the given
     * {@link Pageable} and {@link Specification}.
     * 
     * @param query
     * @param spec
     * @param pageable
     * @return
     */
    private Page<T> readPage(TypedQuery<T> query, Pageable pageable, Specification<T> spec) {
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        Long total = getCountQuery(spec).getSingleResult();
        return new PageImpl<>(query.getResultList(), pageable, total);
    }


    /**
     * Creates a new {@link TypedQuery} from the given {@link Specification}.
     * 
     * @param spec can be {@literal null}
     * @param pageable can be {@literal null}
     * @return
     */
    private TypedQuery<T> getQuery(Specification<T> spec, Pageable pageable) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getDomainClass()).where();

        Root<T> root = applySpecificationToCriteria(spec, query);
        query.select(root);

        if (pageable != null) {
            query.orderBy(toOrders(pageable.getSort(), root, builder));
        }

        return getEntityManager().createQuery(query);
    }


    /**
     * Creates a {@link TypedQuery} for the given {@link Specification} and
     * {@link Sort}.
     * 
     * @param spec
     * @param sort
     * @return
     */
    private TypedQuery<T> getQuery(Specification<T> spec, Sort sort) {

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getDomainClass());

        Root<T> root = applySpecificationToCriteria(spec, query);
        query.select(root);

        if (sort != null) {
            query.orderBy(toOrders(sort, root, builder));
        }

        return getEntityManager().createQuery(query);
    }


    /**
     * Creates a new count query for the given {@link Specification}.
     * 
     * @param spec can be {@literal null}.
     * @return
     */
    private TypedQuery<Long> getCountQuery(Specification<T> spec) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<T> root = applySpecificationToCriteria(spec, query);
        query.select(builder.count(root)).distinct(true);

        return getEntityManager().createQuery(query);
    }


    /**
     * Applies the given {@link Specification} to the given
     * {@link CriteriaQuery}.
     * 
     * @param spec can be {@literal null}
     * @param query
     * @return
     */
    private <S> Root<T> applySpecificationToCriteria(Specification<T> spec, CriteriaQuery<S> query) {
        Assert.notNull(query);
        Root<T> root = query.from(getDomainClass());
        if (spec == null) {
            return root;
        }

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        Predicate predicate = spec.toPredicate(root, query, builder);
        Predicate active = builder.isTrue(root.<Boolean>get("active"));

        query.where(active);

        if (predicate != null) {
            query.where(
                builder.and(predicate, active)
            );
        }

        return root;
    }
    
    /**
     * Turns the given {@link Sort} into
     * {@link javax.persistence.criteria.Order}s.
     * 
     * @param sort
     * @param root
     * @param cb
     * @return
     */
    private List<javax.persistence.criteria.Order> toOrders(Sort sort, Root<?> root, CriteriaBuilder cb) {
        List<javax.persistence.criteria.Order> orders = new ArrayList<>();

        if (sort == null) {
            return orders;
        }

        for (Sort.Order order : sort) {
            orders.add(toJpaOrder(order, root, cb));
        }

        return orders;
    }
    
    /**
     * Creates a criteria API {@link javax.persistence.criteria.Order} from the
     * given {@link Order}.
     * 
     * @param order
     * @param root
     * @param cb
     * @return
     */
    private static javax.persistence.criteria.Order toJpaOrder(Sort.Order order, Root<?> root, CriteriaBuilder cb) {
        Expression<?> expression;
        String pathString = order.getProperty();
        String[] pathElements = pathString.split("\\.");
        int pathSize = pathElements.length;

        if (pathSize > 1) {
            Join<Object, Object> path = root.join(pathElements[0]);
            for (int i = 1; i < pathSize - 1; i++) {
                path = path.join(pathElements[i]);
            }
            expression = path.get(pathElements[pathSize - 1]);
        } else {
            expression = root.get(pathString);
        }

        return order.isAscending() ? cb.asc(expression) : cb.desc(expression);
    }

    public abstract Page<T> search(String searchQuery, PageRequest pageRequest);

}
