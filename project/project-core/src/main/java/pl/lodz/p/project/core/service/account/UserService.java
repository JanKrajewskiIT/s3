package pl.lodz.p.project.core.service.account;

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface UserService {

	List<UserDTO> getAll();

	void createUser(UserDTO userDTO) throws UniqueConstraintViolationException;

	void editUser(UserDTO userDTO);

	public void editUserPassword(UserDTO userDTO);
	
	void editUserEmailAddress(UserDTO userDTO);

	UserDTO getUserByEmail(String email);

}
