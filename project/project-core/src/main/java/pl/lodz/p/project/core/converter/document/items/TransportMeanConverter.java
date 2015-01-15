package pl.lodz.p.project.core.converter.document.items;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.items.TransportMean;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class TransportMeanConverter implements Converter<TransportMean, TransportMeanDTO>{

	@Override
	public TransportMean convertDTO(TransportMeanDTO objectDTO) {
		TransportMean entity = new TransportMean();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public TransportMeanDTO convertEntity(TransportMean entity) {
		TransportMeanDTO objectDTO = new TransportMeanDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}

}
