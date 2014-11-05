package pl.lodz.p.project.core.service.account;

import java.util.List;

import pl.lodz.p.project.core.dto.account.UserDTO;

/**
 *
 * @author Janiu
 */
public interface UserService {

    public List<UserDTO> getAll();
    
    public UserDTO getOneById(Long id);

}
