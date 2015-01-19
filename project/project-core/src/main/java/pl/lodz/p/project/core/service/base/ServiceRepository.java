package pl.lodz.p.project.core.service.base;

import org.springframework.data.domain.Persistable;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public interface ServiceRepository<E extends Persistable<Long>, D extends Serializable>  {

    public E save(D objectDTO);

    public void save(List<D> objectList);

    public D getOneById(Long id);

    public boolean exists(Long id);

    public List<D> getAll();

    public List<D> getAll(List<Long> idList);

    public long count();

    public void delete(Long id);

    public void delete(D objectDTO);

    public void delete(List<D> objectList);

    public void deleteAll();

    public Page<D> search(String searchQuery, PageRequest pageRequest);

}
