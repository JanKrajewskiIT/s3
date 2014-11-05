package pl.lodz.p.project.core.service.account;

import java.util.List;

import pl.lodz.p.project.core.dto.account.RoleDTO;

/**
 *
 * @author Janiu
 */
public interface RoleService {

    List<RoleDTO> getAll();

	RoleDTO getRoleByName(String name);

}
