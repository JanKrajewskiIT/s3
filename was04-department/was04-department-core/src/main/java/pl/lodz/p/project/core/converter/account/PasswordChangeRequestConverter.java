package pl.lodz.p.project.core.converter.account;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.project.core.dto.account.UserDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class PasswordChangeRequestConverter implements Converter<PasswordChangeRequest, PasswordChangeRequestDTO> {

    @Inject
	private UserConverter userConverter;
	
	@Override
	public PasswordChangeRequest convertDTO(PasswordChangeRequestDTO objectDTO) {
		User user = userConverter.convertDTO(objectDTO.getUser());
		
		PasswordChangeRequest entity = new PasswordChangeRequest();
		entity.setId(objectDTO.getId());
		entity.setUser(user);
		entity.setCreationDate(objectDTO.getCreationDate());		
		return entity;
	}

	@Override
	public PasswordChangeRequestDTO convertEntity(PasswordChangeRequest entity) {
		UserDTO userDTO = userConverter.convertEntity(entity.getUser());
		
		PasswordChangeRequestDTO objectDTO = new PasswordChangeRequestDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setUser(userDTO);
		objectDTO.setCreationDate(entity.getCreationDate());		
		return objectDTO;
	}

}
