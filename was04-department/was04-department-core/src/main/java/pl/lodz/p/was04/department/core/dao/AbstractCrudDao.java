package pl.lodz.p.was04.department.core.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Milczu
 *
 * @param <T>
 * @param <ID>
 */
@Repository
@Transactional
public abstract class AbstractCrudDao<T extends Persistable<ID>, ID extends Serializable> implements CrudDao<T, ID> {

	private static final String COUNT_QUERY = "select count(e) from %s e";
	private static final String DELETE_ALL_QUERY_STRING = "delete from %s x";

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<T> domainClass;

	public AbstractCrudDao(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	@Override
	public <S extends T> S save(S entity) {
		if (entity.isNew()) {
			entityManager.persist(entity);
			return entity;
		} else {
			return entityManager.merge(entity);
		}
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		List<S> result = new ArrayList<S>();

		if (entities == null) {
			return result;
		}

		for (S entity : entities) {
			result.add(save(entity));
		}

		return result;
	}

	@Override
	public T findOne(ID id) {
		return entityManager.find(domainClass, id);
	}

	@Override
	public boolean exists(ID id) {
		return findOne(id) != null;
	}

	@Override
	public long count() {
		return entityManager.createQuery(String.format(COUNT_QUERY, domainClass.getName()), Long.class)
				.getSingleResult();
	}

	@Override
	public void delete(ID id) {
		T entity = findOne(id);
		delete(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		if (entities != null) {
			for (T entity : entities) {
				delete(entity);
			}
		}
	}

	@Override
	public void deleteAll() {
		entityManager.createQuery(String.format(DELETE_ALL_QUERY_STRING, domainClass.getName())).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return entityManager.createQuery("from " + domainClass.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Iterable<ID> ids) {
		if (ids == null || !ids.iterator().hasNext()) {
			return new ArrayList<>();
		} else {
			return entityManager.createQuery("select e from " + domainClass.getName() + " e WHERE e.id in (:ids)")
					.setParameter("ids", ids).getResultList();
		}
	}
	
	public void flush() {
		entityManager.flush();
	}
	 
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getDomainClass() {
		return domainClass;
	}

}
