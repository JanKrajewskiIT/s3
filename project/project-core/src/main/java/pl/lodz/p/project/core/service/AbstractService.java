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
	
    @Autowired
    protected CrudDao<E, Long> dao;
    
    @Autowired
    protected Converter<E, D> converter;
    
    public List<D> getAll() {
    	return Lists.transform(dao.findAll(), transformer);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
    
    public void delete(D objectDTO) {
        E entity = converter.convertDTO(objectDTO);
        dao.delete(entity);    	
    }

    public void save(D objectDTO) {
        E entity = converter.convertDTO(objectDTO);
        dao.save(entity);
    }

    public D getOneById(Long id) {
    	E entity = dao.findOne(id);
    	return converter.convertEntity(entity);
    }
    
    private class Transformer implements Function<E, D> {
    	
    	@Override
    	public D apply(E input) {
        	return converter.convertEntity(input);
    	}
    	
    }

}
