package pl.lodz.p.project.core.converter.account;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.UserDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class UserConverter implements Converter<User, UserDTO> {
	
	@Override
	public User convertDTO(UserDTO objectDTO) {
		User entity = new User();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setFirstName(objectDTO.getFirstName());
		entity.setSecondName(objectDTO.getSecondName());
		entity.setPassword(objectDTO.getPassword());
		entity.setEmail(objectDTO.getEmail());
		return entity;
	}

	@Override
	public UserDTO convertEntity(User entity) {
		UserDTO objectDTO = new UserDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setFirstName(entity.getFirstName());
		objectDTO.setSecondName(entity.getSecondName());
		objectDTO.setPassword(entity.getPassword());
		objectDTO.setEmail(entity.getEmail());
		return objectDTO;
	}
}
