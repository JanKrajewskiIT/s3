package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;
import pl.lodz.p.project.core.service.base.ServiceRepository;

/**
 *
 * @author Janiu
 */
public interface UserService extends ServiceRepository<User, UserDTO> {

	void createUser(UserDTO userDTO) throws UniqueConstraintViolationException;

	void editUser(UserDTO userDTO);

	public void editUserPassword(UserDTO userDTO);
	
	void editUserEmailAddress(UserDTO userDTO);

	UserDTO getUserByEmail(String email);

}
