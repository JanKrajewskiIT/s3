package pl.lodz.p.project.core.service.account;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class UserServiceImpl extends AbstractService<User, UserDTO> implements UserService {

	/**
	 * Retrieves all users from the DB and creates a list of DTO representing
	 * those users. Invokes {@link AccountManagerLocal#getAllUsers()
     * }
	 *
	 * @return the list of DTO represeting all users found in the DB.
	 */
	@RolesAllowed("accountManagement")
	@Override
	public List<UserDTO> getAll() {
		return super.getAll();
	}
	
}
