package pl.lodz.p.project.core.service.account;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.account.RoleConverter;
import pl.lodz.p.project.core.dao.account.PendingInvitationDao;
import pl.lodz.p.project.core.domain.account.PendingInvitation;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;
import pl.lodz.p.project.core.util.MailSender;

/**
 *
 * @author Janiu, Łukasz Gadomski
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PendingInvitationServiceImpl extends AbstractService<PendingInvitation, PendingInvitationDTO> implements PendingInvitationService {

	private final static String ACCESS_LEVEL = "accountManagement";
	
	@Autowired
	private MailSender mailSender;
		
	@Autowired
	private RoleConverter roleConverter;
	
	/**
	 * Sends an invitation mail to the given e-mail address. Invokes
	 * {@link AccountManagerLocal#sendInvitation(java.lang.String, java.lang.String, java.lang.Integer)}.
	 *
	 * @param registrationURL - the URL of registration page for given user.
	 * @param email - the e-mail address that the mail is to be sent to.
	 * @param roleDTO - the DTO representing the role that is to be added to a new user.
	 */
	@RolesAllowed(ACCESS_LEVEL)
	@Override
	public void sendInvitation(String url, String email, RoleDTO roleDTO) {
		Role role = roleConverter.convertDTO(roleDTO);
		mailSender.sendInvitationMail(url, email, role);
	}

	/**
	 * Retrieves a pending invitation with given token from the DB and creates a DTO representing it. Invokes
	 * {@link AccountManagerLocal#getPendingInvitationByToken(java.lang.String)}.
	 *
	 * @param token - the token of the searched pending invitation.
	 * @return the DTO representing the found pending invitation.
	 */
	@PermitAll
	@Override
	public PendingInvitationDTO getOneByToken(String token) {
		PendingInvitation pendingInvitation = ((PendingInvitationDao) dao).findByToken(token);
		if (pendingInvitation != null) {
			return converter.convertEntity(pendingInvitation);
		}
		return null;
	}
	
	/**
	 * Removes a pending invitation with given ID from the DB. Invokes
	 * {@link AccountManagerLocal#removePendingInvitation(java.lang.Integer)}.
	 *
	 * @param id - the ID of the pending invitation that is to be removed
	 */
	@PermitAll
	@Override
	public void delete(Long id) {
		super.delete(id);
	}
	
}
