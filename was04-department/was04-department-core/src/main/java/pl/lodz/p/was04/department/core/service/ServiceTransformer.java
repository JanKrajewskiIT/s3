package pl.lodz.p.was04.department.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.dao.CrudDao;

/**
 * 
 * @author Janiu
 *
 * @param <T>
 * @param <D>
 */
public class ServiceTransformer<T, D extends Persistable<Long>> {
	
	@Autowired
	CrudDao<D, Long> dao; 
	
	@Inject
	Converter<D, T> converter;
	
	public List<T> transformList() {
		List<T> objectDTOList = new ArrayList<>();
		for(D entity : dao.findAll()) {
			T objectDTO = converter.convertEntity(entity);
			objectDTOList.add(objectDTO);
		}
		return objectDTOList;
	}
	
}