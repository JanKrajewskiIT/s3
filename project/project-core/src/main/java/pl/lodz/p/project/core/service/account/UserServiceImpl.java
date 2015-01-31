package pl.lodz.p.project.core.service.account;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dao.account.RoleDao;
import pl.lodz.p.project.core.dao.account.UserDao;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Janiu, Łukasz Gadomski
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class UserServiceImpl extends AbstractService<User, UserDTO> implements UserService {

	private final static String ACCESS_LEVEL = "accountManagement";
	private final static String PROFILE_ACCESS_LEVEL = "accountManagement";

	private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private User originalUser;
	
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	
	@RolesAllowed(ACCESS_LEVEL)
	@Override
	public List<UserDTO> getAll() {
		UserDTO tmpDTO;
		List<UserDTO> resultList = new ArrayList<>();
		for (User user : userDao.findAll()) {
			tmpDTO = converter.convertEntity(user);
			tmpDTO.setAdmin(isAdmin(user));
			tmpDTO.setManager(isManager(user));
			tmpDTO.setUser(isUser(user));
			resultList.add(tmpDTO);
		}
		return resultList;
	}
	
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

		originalUser.setActive(userDTO.isActive());

		/* admin */
		if (isAdmin(originalUser) && !userDTO.isAdmin()) {
			removeRoleFromUser(adminRole, originalUser);
		} else if (!isAdmin(originalUser) && userDTO.isAdmin()) {
			addRoleToUser(adminRole, originalUser);
		}
		
		/* manager */
		if (isManager(originalUser) && !userDTO.isManager()) {
			removeRoleFromUser(managerRole, originalUser);
		} else if (!isManager(originalUser) && userDTO.isManager()) {
			addRoleToUser(managerRole, originalUser);
		}
		
		/* user */
		if (isUser(originalUser) && !userDTO.isUser()) {
			removeRoleFromUser(userRole, originalUser);
		} else if (!isUser(originalUser) && userDTO.isUser()) {
			addRoleToUser(userRole, originalUser);
		}

		dao.save(originalUser);
		dao.flush();
		roleDao.save(adminRole);
		roleDao.save(managerRole);
		roleDao.save(userRole);

	}

	private boolean isAdmin(User user) {
		Role adminRole = roleDao.findByName("admin");
		return user.getRolesCollection().contains(adminRole);
	}

	private boolean isManager(User user) {
		Role managerRole = roleDao.findByName("manager");
		return user.getRolesCollection().contains(managerRole);
	}

	private boolean isUser(User user) {
		Role userRole = roleDao.findByName("user");
		return user.getRolesCollection().contains(userRole);
	}
	
    @RolesAllowed(ACCESS_LEVEL)
    private void addRoleToUser(Role role, User user) {
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
    }

    @RolesAllowed(ACCESS_LEVEL)
    private void removeRoleFromUser(Role role, User user) {
        user.getRolesCollection().remove(role);
        role.getUsersCollection().remove(user);
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

	@PermitAll
	@Override
	public UserDTO getUserByEmail(String email) {
		UserDTO userDTO = null;
		originalUser = ((UserDao) dao).findByEmail(email);
		if (originalUser != null) {
			userDTO = converter.convertEntity(originalUser);
			userDTO.setAdmin(isAdmin(originalUser));
			userDTO.setManager(isManager(originalUser));
			userDTO.setUser(isUser(originalUser));
		}
		return userDTO;
	}
	
}
