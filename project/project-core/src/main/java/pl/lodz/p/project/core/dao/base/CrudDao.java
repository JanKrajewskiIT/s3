package pl.lodz.p.project.core.dao.base;

import org.springframework.data.domain.Persistable;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Milczu
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudDao<T extends Persistable<ID>, ID extends Serializable> extends CrudRepository<T, ID> {

	@Override
	List<T> findAll();

	@Override
	List<T> findAll(Iterable<ID> ids);

	public List<T> findAllActive();

	void flush();	
	
}
