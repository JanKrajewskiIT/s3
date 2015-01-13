package pl.lodz.p.project.core.converter.account;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.dto.account.RoleDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class RoleConverter implements Converter<Role, RoleDTO> {

	@Override
	public Role convertDTO(RoleDTO objectDTO) {
		Role entity = new Role();
		entity.setId(objectDTO.getId());
		entity.setName(objectDTO.getName());
		return null;
	}

	@Override
	public RoleDTO convertEntity(Role entity) {
		RoleDTO objectDTO = new RoleDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}

}
