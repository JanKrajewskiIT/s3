package pl.lodz.p.was04.department.core.converter.contractor;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.contractor.PostalCode;
import pl.lodz.p.was04.department.core.dto.contractor.PostalCodeDTO;

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
		entity.setCode(objectDTO.getCode());
		entity.setCity(objectDTO.getCity());
		return entity;
	}

	@Override
	public PostalCodeDTO convertEntity(PostalCode entity) {
		PostalCodeDTO objectDTO = new PostalCodeDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setCode(entity.getCode());
		objectDTO.setCity(entity.getCity());
		return objectDTO;
	}

}
