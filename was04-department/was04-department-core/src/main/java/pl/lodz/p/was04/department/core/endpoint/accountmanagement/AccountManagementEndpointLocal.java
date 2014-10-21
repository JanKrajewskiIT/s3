/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.endpoint.accountmanagement;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.PasswordChangeRequestDTO;
import pl.lodz.p.was04.department.core.dto.PendingInvitationDTO;
import pl.lodz.p.was04.department.core.dto.RoleDTO;
import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;

/**
 *
 * @author Łukasz Gadomski
 */
public interface AccountManagementEndpointLocal {

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

    PasswordChangeRequestDTO getPasswordChangeRequestById(String id);

    void removePasswordChangeRequest(String id);

}
