package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.project.core.service.base.ServiceRepository;

/**
*
* @author Janiu
*/
public interface PasswordChangeRequestService extends ServiceRepository<PasswordChangeRequest, PasswordChangeRequestDTO> {
	
	void sendPasswordChangeRequest(String passwordResetURL, String email);

}
