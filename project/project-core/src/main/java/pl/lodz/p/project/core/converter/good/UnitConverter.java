package pl.lodz.p.project.core.converter.good;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.good.Unit;
import pl.lodz.p.project.core.dto.good.UnitDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class UnitConverter implements Converter<Unit, UnitDTO> {

	@Override
	public Unit convertDTO(UnitDTO objectDTO) {
		Unit entity = new Unit();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		entity.setZeroPlaces(objectDTO.getZeroPlaces());
		return entity;
	}

	@Override
	public UnitDTO convertEntity(Unit entity) {
		UnitDTO objectDTO = new UnitDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setName(entity.getName());
		objectDTO.setZeroPlaces(entity.getZeroPlaces());
		return objectDTO;
	}

}
