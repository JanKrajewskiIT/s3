package pl.lodz.p.project.core.converter.good;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.good.Tax;
import pl.lodz.p.project.core.dto.good.TaxDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class TaxConverter implements Converter<Tax, TaxDTO> {

	@Override
	public Tax convertDTO(TaxDTO objectDTO) {
		Tax entity = new Tax();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		entity.setValue(objectDTO.getValue());
		return entity;
	}

	@Override
	public TaxDTO convertEntity(Tax entity) {
		TaxDTO objectDTO = new TaxDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setName(entity.getName());
		objectDTO.setValue(entity.getValue());
		return objectDTO;
	}

}
