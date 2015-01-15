package pl.lodz.p.project.core.service.account;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dao.account.RoleDao;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class RoleServiceImpl extends AbstractService<Role, RoleDTO> implements RoleService {

	private final static String ACCESS_LEVEL = "accountManagement";
	
	/**
	 * Retrieves all roles from the DB and creates a list of DTO representing
	 * those roles. Invokes {@link AccountManagerLocal#getAllRoles()}.
	 *
	 * @return the list of DTO represeting all roles found in the DB.
	 */
	@RolesAllowed(ACCESS_LEVEL)
	@Override
	public List<RoleDTO> getAll() {
		return super.getAll();
	}

	@PermitAll
	@Override
	public RoleDTO getRoleByName(String name) {
		Role role = ((RoleDao) dao).findByName(name);
		if (role != null) {
			return converter.convertEntity(role);
		}
		return null;
	}
	
}
