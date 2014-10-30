package pl.lodz.p.was04.department.core.converter.document;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.document.TransportMean;
import pl.lodz.p.was04.department.core.dto.document.TransportMeanDTO;

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
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public TransportMeanDTO convertEntity(TransportMean entity) {
		TransportMeanDTO objectDTO = new TransportMeanDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}

}
