package pl.lodz.p.project.core.converter.account;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.account.PendingInvitation;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.RoleDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class PendingInvitationConverter implements Converter<PendingInvitation, PendingInvitationDTO>{

    @Inject
	private RoleConverter roleConverter;
	
	@Override
	public PendingInvitation convertDTO(PendingInvitationDTO objectDTO) {
		Role role = roleConverter.convertDTO(objectDTO.getRole());
		
		PendingInvitation entity = new PendingInvitation();
		entity.setId(objectDTO.getId());
		entity.setEmail(objectDTO.getEmail());
		entity.setRole(role);
		entity.setToken(objectDTO.getToken());
		entity.setCreationDate(objectDTO.getCreationDate());
		return entity;
	}

	@Override
	public PendingInvitationDTO convertEntity(PendingInvitation entity) {
		RoleDTO roleDTO = roleConverter.convertEntity(entity.getRole());
				
		PendingInvitationDTO objectDTO = new PendingInvitationDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setEmail(entity.getEmail());
		objectDTO.setRole(roleDTO);
		objectDTO.setToken(entity.getToken());
		objectDTO.setCreationDate(entity.getCreationDate());
		return objectDTO;
	}

}
