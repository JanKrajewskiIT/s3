package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.domain.account.PendingInvitation;
import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.service.base.ServiceRepository;

/**
*
* @author Janiu
*/
public interface PendingInvitationService extends ServiceRepository<PendingInvitation, PendingInvitationDTO> {

	void sendInvitation(String url, String email, RoleDTO roleDTO);

	PendingInvitationDTO getOneByToken(String token);

}
