package pl.lodz.p.project.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.dao.CrudDao;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * 
 * @author Janiu
 *
 * @param <E>
 * @param <D>
 */
public abstract class AbstractService<E extends Persistable<Long>, D> {
	
    protected final Transformer transformer = new Transformer();
    protected final ReverseTransformer reverseTransformer = new ReverseTransformer();
	
    @Autowired
    protected CrudDao<E, Long> dao;
    
    @Autowired
    protected Converter<E, D> converter;

    public void save(D objectDTO) {
        E entity = converter.convertDTO(objectDTO);
        dao.save(entity);
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
