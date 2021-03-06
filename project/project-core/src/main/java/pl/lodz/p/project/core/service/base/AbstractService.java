package pl.lodz.p.project.core.service.base;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Janiu
 *
 * @param <E>
 * @param <D> 
 */
public abstract class AbstractService<E extends BaseEntity<Long>, D extends Serializable> {

    protected final Transformer transformer = new Transformer();
    protected final ReverseTransformer reverseTransformer = new ReverseTransformer();

    @Autowired
    protected CrudDao<E, Long> dao;
    
    @Autowired
    protected Converter<E, D> converter;

    public E save(D objectDTO) {
        E entity = converter.convertDTO(objectDTO);
        return dao.save(entity);
    }
    
    public void save(List<D> objectList) {
    	List<E> entityList = Lists.transform(objectList, reverseTransformer);
        dao.save(entityList);
    }

    public D getOneById(Long id) {
    	E entity = dao.findOne(id);
    	return converter.convertEntity(entity);
    }

	public boolean exists(Long id) {
		return dao.exists(id);
	}
	
    public List<D> getAll() {
    	List<E> entityList = dao.findAll();
    	return Lists.transform(entityList, transformer);
    }

    public List<D> getAllActive() {
        List<E> entityList = dao.findAllActive();
        return Lists.transform(entityList, transformer);
    }

    public List<D> getAll(List<Long> idList) {
    	List<E> entityList = dao.findAll(idList);
    	return Lists.transform(entityList, transformer);
    }
    
    public long count() {
    	return dao.count();
    }
    
    public void delete(Long id) {
        dao.delete(id);
    }

    public void delete(D objectDTO) {
        E entity = converter.convertDTO(objectDTO);
        dao.delete(entity);
    }
    
    public void delete(List<D> objectList) {
    	List<E> entityList = Lists.transform(objectList, reverseTransformer);
    	dao.delete(entityList);
    }
    
    public void deleteAll() {
    	dao.deleteAll();
    }

    public void disactive(D objectDTO) {
        E entity = converter.convertDTO(objectDTO);
        entity.setActive(false);
        dao.save(entity);
    }

    public Page<D> search(String searchQuery, PageRequest pageRequest) {
        return (Page<D>) new Object();
    }

    private class Transformer implements Function<E, D> {
    	
    	@Override
    	public D apply(E input) {
        	return converter.convertEntity(input);
    	}    	
    }
    
    private class ReverseTransformer implements Function<D, E> {
    	
    	@Override
    	public E apply(D input) {
        	return converter.convertDTO(input);
    	}    	
    }

}
