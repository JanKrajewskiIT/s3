package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.dto.account.PasswordChangeRequestDTO;

/**
*
* @author Janiu
*/
public interface PasswordChangeRequestService {
	
	void sendPasswordChangeRequest(String passwordResetURL, String email);
	
	PasswordChangeRequestDTO getOneById(Long id);
	
	void delete(Long id);

}
