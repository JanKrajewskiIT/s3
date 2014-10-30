package pl.lodz.p.was04.department.core.converter.good;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.good.GoodGroup;
import pl.lodz.p.was04.department.core.dto.good.GoodGroupDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class GoodGroupConverter implements Converter<GoodGroup, GoodGroupDTO> {

	@Override
	public GoodGroup convertDTO(GoodGroupDTO objectDTO) {
		GoodGroup entity = new GoodGroup();
		entity.setId(objectDTO.getId());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public GoodGroupDTO convertEntity(GoodGroup entity) {
		GoodGroupDTO objectDTO = new GoodGroupDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}

}