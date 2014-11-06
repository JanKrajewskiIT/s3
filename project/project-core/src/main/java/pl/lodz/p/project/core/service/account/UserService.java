package pl.lodz.p.project.core.service.account;

import java.util.List;

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;

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
