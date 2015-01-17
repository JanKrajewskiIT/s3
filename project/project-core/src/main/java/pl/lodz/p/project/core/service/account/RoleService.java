package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.service.base.ServiceRepository;

/**
 *
 * @author Janiu
 */
public interface RoleService extends ServiceRepository<Role, RoleDTO> {

	RoleDTO getRoleByName(String name);

}
