package pl.lodz.p.was04.department.core.converter.account;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.account.User;
import pl.lodz.p.was04.department.core.dto.account.UserDTO;

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
		objectDTO.setFirstName(entity.getFirstName());
		objectDTO.setSecondName(entity.getSecondName());
		objectDTO.setPassword(entity.getPassword());
		objectDTO.setEmail(entity.getEmail());
		return objectDTO;
	}
}
