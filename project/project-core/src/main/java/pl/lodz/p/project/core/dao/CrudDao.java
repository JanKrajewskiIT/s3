package pl.lodz.p.project.core.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Persistable;
import org.springframework.data.repository.CrudRepository;

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

	void flush();	
	
}
