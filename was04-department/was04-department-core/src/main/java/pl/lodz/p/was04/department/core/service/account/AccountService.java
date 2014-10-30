package pl.lodz.p.was04.department.core.service.account;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.was04.department.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.was04.department.core.dto.account.RoleDTO;
import pl.lodz.p.was04.department.core.dto.account.UserDTO;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;

/**
 *
 * @author Łukasz Gadomski, Janiu
 */
public interface AccountService {

    List<RoleDTO> getAllRoles();

    RoleDTO getRoleByName(String roleName);

    void sendInvitation(String registrationURL, String email, RoleDTO roleDTO);

    PendingInvitationDTO getPendingInvitationByToken(String token);

    void removePendingInvitation(Long id);

    List<UserDTO> getAllUsers();

    void createUser(UserDTO userDTO) throws UniqueConstraintViolationException;

    void editUser(UserDTO userDTO);

    void editUserPassword(UserDTO userDTO);

    void editUserEmailAddress(UserDTO userDTO);

    UserDTO getUserByEmail(String email);

    void sendPasswordChangeRequest(String passwordResetURL, String email);

    PasswordChangeRequestDTO getPasswordChangeRequestById(Long id);

    void removePasswordChangeRequest(Long id);

}
