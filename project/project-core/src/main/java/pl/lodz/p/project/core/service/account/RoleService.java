package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.dto.account.RoleDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface RoleService {

    List<RoleDTO> getAll();

	RoleDTO getRoleByName(String name);

}
