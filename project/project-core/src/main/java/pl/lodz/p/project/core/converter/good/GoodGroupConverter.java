package pl.lodz.p.project.core.converter.good;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.good.GoodGroup;
import pl.lodz.p.project.core.dto.good.GoodGroupDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

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
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public GoodGroupDTO convertEntity(GoodGroup entity) {
		GoodGroupDTO objectDTO = new GoodGroupDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}

}
