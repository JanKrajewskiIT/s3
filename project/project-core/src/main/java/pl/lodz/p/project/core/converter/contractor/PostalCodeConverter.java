package pl.lodz.p.project.core.converter.contractor;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.contractor.PostalCode;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 * 
 * @author Janiu
 *
 */
@Named
@ApplicationScoped
public class PostalCodeConverter implements Converter<PostalCode, PostalCodeDTO>  {

	@Override
	public PostalCode convertDTO(PostalCodeDTO objectDTO) {
		PostalCode entity = new PostalCode();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setCode(objectDTO.getCode());
		entity.setCity(objectDTO.getCity());
		return entity;
	}

	@Override
	public PostalCodeDTO convertEntity(PostalCode entity) {
		PostalCodeDTO objectDTO = new PostalCodeDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setCode(entity.getCode());
		objectDTO.setCity(entity.getCity());
		return objectDTO;
	}

}
