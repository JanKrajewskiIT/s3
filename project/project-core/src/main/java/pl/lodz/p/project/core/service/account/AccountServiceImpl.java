package pl.lodz.p.project.core.service.account;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.account.PasswordChangeRequestConverter;
import pl.lodz.p.project.core.converter.account.PendingInvitationConverter;
import pl.lodz.p.project.core.converter.account.RoleConverter;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.dao.account.PasswordChangeRequestDao;
import pl.lodz.p.project.core.dao.account.PendingInvitationDao;
import pl.lodz.p.project.core.dao.account.RoleDao;
import pl.lodz.p.project.core.dao.account.UserDao;
import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.domain.account.PendingInvitation;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.util.MailSender;

/**
 * EJB Stateful session bean serving as an endpoint for account management.
 *
 * @author Łukasz Gadomski, Janiu
 */
@Component
@Interceptors({ TrackerInterceptor.class })
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PendingInvitationDao pendingInvitationDao;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private PasswordChangeRequestDao passwordChangeRequestDao;

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Autowired
	private PendingInvitationConverter pendingInvitationConverter;

	@Autowired
	private PasswordChangeRequestConverter passwordChangeRequestConverter;
	
	private User originalUser;

	/**
	 * Retrieves all roles from the DB and creates a list of DTO representing
	 * those roles. Invokes {@link AccountManagerLocal#getAllRoles()
     * }.
	 *
	 * @return the list of DTO represeting all roles found in the DB.
	 */
	@RolesAllowed("accountManagement")
	@Override
	public List<RoleDTO> getAllRoles() {
		List<RoleDTO> roleList = new ArrayList<>();
		for (Role role : roleDao.findAll()) {
			RoleDTO roleDTO = roleConverter.convertEntity(role);
			roleList.add(roleDTO);
		}
		return roleList;
	}

	@PermitAll
	@Override
	public RoleDTO getRoleByName(String name) {
		Role role = roleDao.findByName(name);
		if (role != null) {
			return roleConverter.convertEntity(role);
		}
		return null;
	}

	/**
	 * Sends an invitation mail to the given e-mail address. Invokes
	 * {@link AccountManagerLocal#sendInvitation(java.lang.String, java.lang.String, java.lang.Integer)
     * }
	 * .
	 *
	 * @param registrationURL
	 *            the URL of registration page for given user.
	 * @param email
	 *            the e-mail address that the mail is to be sent to.
	 * @param roleDTO
	 *            the DTO representing the role that is to be added to a new
	 *            user.
	 */
	@RolesAllowed("accountManagement")
	@Override
	public void sendInvitation(String url, String email, RoleDTO roleDTO) {
		Role role = roleConverter.convertDTO(roleDTO);
		mailSender.sendInvitationMail(url, email, role);
	}

	/**
	 * Retrieves a pending invitation with given token from the DB and creates a
	 * DTO representing it. Invokes
	 * {@link AccountManagerLocal#getPendingInvitationByToken(java.lang.String)
     * }
	 * .
	 *
	 * @param token
	 *            the token of the searched pending invitation.
	 * @return the DTO representing the found pending invitation.
	 */
	@PermitAll
	@Override
	public PendingInvitationDTO getPendingInvitationByToken(String token) {
		PendingInvitation pendingInvitation = pendingInvitationDao.findByToken(token);
		if (pendingInvitation != null) {
			return pendingInvitationConverter.convertEntity(pendingInvitation);
		}
		return null;
	}

	/**
	 * Removes a pending invitation with given ID from the DB. Invokes
	 * {@link AccountManagerLocal#removePendingInvitation(java.lang.Integer)
     * }.
	 *
	 * @param id
	 *            the ID of the pending invitation that is to be removed
	 */
	@PermitAll
	@Override
	public void removePendingInvitation(Long id) {
        pendingInvitationDao.delete(pendingInvitationDao.findOne(id));
	}

	/**
	 * Retrieves all users from the DB and creates a list of DTO representing
	 * those users. Invokes {@link AccountManagerLocal#getAllUsers()
     * }
	 *
	 * @return the list of DTO represeting all users found in the DB.
	 */
	@RolesAllowed("accountManagement")
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> userList = new ArrayList<>();
		for (User user : userDao.findAll()) {
			UserDTO userDTO = userConverter.convertEntity(user);
			userList.add(userDTO);
		}
		return userList;
	}

	/**
	 * Creates a new user entity with given roles based on the given DTO and
	 * stores it in the DB. Invokes
	 * {@link AccountManagerLocal#createUser(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)
     * }
	 * and
	 * {@link AccountManagerLocal#addRoleToUser(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.Role, pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)
     * }
	 * to store the user entity and add a role to it and
	 * {@link AccountManagerLocal#getRoleById(java.lang.Integer) } to retrieve a
	 * role entity mapped by the roleDTO.
	 *
	 * @param userDTO
	 *            the DTO representing a new user.
	 * @throws pl.lodz.p.was04.headoffice.exception.UniqueConstraintViolationException
	 */
	@PermitAll
	@Override
	public void createUser(UserDTO userDTO) throws UniqueConstraintViolationException {
		User user = userConverter.convertDTO(userDTO);
		user.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
		
		String name = userDTO.getRoleSet().iterator().next().getName();
		Role role = roleDao.findByName(name);
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
        userDao.save(user);
        userDao.flush();
        roleDao.save(role);
	}

	@RolesAllowed("accountManagement")
	@Override
	public void editUser(UserDTO userDTO) {
		getUserByEmail(userDTO.getEmail());
		Role adminRole = roleDao.findByName("admin");
		Role managerRole = roleDao.findByName("manager");
		Role userRole = roleDao.findByName("user");
		
		/* admin */
		if (originalUser.getRolesCollection().contains(adminRole) && !userDTO.isAdmin()) {
			removeRoleFromUser(adminRole, originalUser);
		} else if (!originalUser.getRolesCollection().contains(adminRole) && userDTO.isAdmin()) {
			addRoleToUser(adminRole, originalUser);
		}
		
		/* manager */
		if (originalUser.getRolesCollection().contains(managerRole) && !userDTO.isManager()) {
			removeRoleFromUser(managerRole, originalUser);
		} else if (!originalUser.getRolesCollection().contains(managerRole) && userDTO.isManager()) {
			addRoleToUser(managerRole, originalUser);
		}
		
		/* user */
		if (originalUser.getRolesCollection().contains(userRole) && !userDTO.isUser()) {
			removeRoleFromUser(userRole, originalUser);
		} else if (!originalUser.getRolesCollection().contains(userRole) && userDTO.isUser()) {
			addRoleToUser(userRole, originalUser);
		}
	}
	
	/**
     * Adds a given role to the given user. Invokes {@link UserFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)
     * } and {@link RoleFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.Role) }.
     *
     * @param role the role to be added.
     * @param user the user to receive the role.
     */
    @RolesAllowed("accountManagement")
    private void addRoleToUser(Role role, User user) {
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * Removes a given role from the given user. Invokes {@link UserFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)
     * } and {@link RoleFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.Role) }.
     *
     * @param role the role to be removed.
     * @param user the user to lose the role.
     */
    @RolesAllowed("accountManagement")
    private void removeRoleFromUser(Role role, User user) {
        user.getRolesCollection().remove(role);
        role.getUsersCollection().remove(user);
        userDao.save(user);
        roleDao.save(role);
    }
    
	@PermitAll
	@Override
	public void editUserPassword(UserDTO userDTO) {
		originalUser.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
        userDao.save(originalUser);
        userDao.flush();
	}

	@RolesAllowed("profileEdition")
	@Override
	public void editUserEmailAddress(UserDTO userDTO) {
		originalUser.setEmail(userDTO.getEmail());
        userDao.save(originalUser);
        userDao.flush();
	}

	/**
	 * Retrieves a user with given e-mail address from the DB and creates a DTO
	 * based on the result. Invokes
	 * {@link AccountManagerLocal#getUserByEmail(java.lang.String)
     * }.
	 *
	 * @param email
	 *            the email of the searched user.
	 * @return the found user.
	 */
	@PermitAll
	@Override
	public UserDTO getUserByEmail(String email) {
		originalUser = userDao.findByEmail(email);
		if (originalUser != null) {
			return userConverter.convertEntity(originalUser);
		}
		return null;
	}

	@PermitAll
	@Override
	public void sendPasswordChangeRequest(String passwordResetURL, String email) {
		User user = userDao.findByEmail(email);
		mailSender.sendPasswordChangeRequestMail(passwordResetURL, user);
	}

	@PermitAll
	@Override
	public PasswordChangeRequestDTO getPasswordChangeRequestById(Long id) {
		PasswordChangeRequest passwordChangeRequest = passwordChangeRequestDao.findOne(id);
		if (passwordChangeRequest != null) {
			return passwordChangeRequestConverter.convertEntity(passwordChangeRequest);
		}
		return null;
	}

	@PermitAll
	@Override
	public void removePasswordChangeRequest(Long id) {
        passwordChangeRequestDao.delete(passwordChangeRequestDao.findOne(id));        
	}

}
