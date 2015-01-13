package pl.lodz.p.project.core.service.account;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.dao.account.RoleDao;
import pl.lodz.p.project.core.dao.account.UserDao;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class UserServiceImpl extends AbstractService<User, UserDTO> implements UserService {

	private final static String ACCESS_LEVEL = "accountManagement";
	private final static String PROFILE_ACCESS_LEVEL = "accountManagement";
	
	private User originalUser;
	
	@Autowired
	private RoleDao roleDao;
	
	/**
	 * Retrieves all users from the DB and creates a list of DTO representing those users. Invokes 
	 * {@link AccountManagerLocal#getAllUsers()}
	 *
	 * @return the list of DTO represeting all users found in the DB.
	 */
	@RolesAllowed(ACCESS_LEVEL)
	@Override
	public List<UserDTO> getAll() {
		return super.getAll();
	}
	
	/**
	 * Creates a new user entity with given roles based on the given DTO and stores it in the DB. Invokes
	 * {@link AccountManagerLocal#createUser(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)}
	 * and
	 * {@link AccountManagerLocal#addRoleToUser(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.Role, pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)}
	 * to store the user entity and add a role to it and
	 * {@link AccountManagerLocal#getRoleById(java.lang.Integer)} to retrieve a role entity mapped by the roleDTO.
	 *
	 * @param userDTO - the DTO representing a new user.
	 * @throws pl.lodz.p.was04.headoffice.exception.UniqueConstraintViolationException
	 */
	@PermitAll
	@Override
	public void createUser(UserDTO userDTO) {
		User user = converter.convertDTO(userDTO);
		user.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
		
		String name = userDTO.getRoleSet().iterator().next().getName();
		Role role = roleDao.findByName(name);
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
        dao.save(user);
        dao.flush();
        roleDao.save(role);
	}
	
	@RolesAllowed(ACCESS_LEVEL)
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
     * Adds a given role to the given user. Invokes 
     * {@link UserFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)} 
     * and 
     * {@link RoleFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.Role)}.
     *
     * @param role the role to be added.
     * @param user the user to receive the role.
     */
    @RolesAllowed(ACCESS_LEVEL)
    private void addRoleToUser(Role role, User user) {
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
        dao.save(user);
        roleDao.save(role);
    }

    /**
     * Removes a given role from the given user. Invokes 
     * {@link UserFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.User)} 
     * and 
     * {@link RoleFacadeLocal#edit(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.Role)}.
     *
     * @param role the role to be removed.
     * @param user the user to lose the role.
     */
    @RolesAllowed(ACCESS_LEVEL)
    private void removeRoleFromUser(Role role, User user) {
        user.getRolesCollection().remove(role);
        role.getUsersCollection().remove(user);
        dao.save(user);
        roleDao.save(role);
    }	
    
    @PermitAll
	@Override
	public void editUserPassword(UserDTO userDTO) {
		originalUser.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
        dao.save(originalUser);
        dao.flush();
	}


	@RolesAllowed(PROFILE_ACCESS_LEVEL)
	@Override
	public void editUserEmailAddress(UserDTO userDTO) {
		originalUser.setEmail(userDTO.getEmail());
        dao.save(originalUser);
        dao.flush();
	}

	/**
	 * Retrieves a user with given e-mail address from the DB and creates a DTO based on the result. Invokes
	 * {@link AccountManagerLocal#getUserByEmail(java.lang.String)}.
	 *
	 * @param email - the email of the searched user.
	 * @return the found user.
	 */
	@PermitAll
	@Override
	public UserDTO getUserByEmail(String email) {
		originalUser = ((UserDao) dao).findByEmail(email);
		if (originalUser != null) {
			return converter.convertEntity(originalUser);
		}
		return null;
	}
	
}
