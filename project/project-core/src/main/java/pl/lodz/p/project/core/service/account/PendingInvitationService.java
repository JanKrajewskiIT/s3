package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.RoleDTO;

/**
*
* @author Janiu
*/
public interface PendingInvitationService {

	void sendInvitation(String url, String email, RoleDTO roleDTO);

	PendingInvitationDTO getOneByToken(String token);
	
	void delete(Long id);
	
}
