/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.manager.accountmanagement;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.PasswordChangeRequest;
import pl.lodz.p.was04.department.core.domain.PendingInvitation;
import pl.lodz.p.was04.department.core.domain.Role;
import pl.lodz.p.was04.department.core.domain.User;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;

/**
 *
 * @author Łukasz Gadomski
 */
public interface AccountManagerLocal {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByName(String roleName);

    void sendInvitation(String registrationURL, String email, String roleName);

    PendingInvitation getPendingInvitationByToken(String token);

    void removePendingInvitation(Long id);

    void createUser(User user, String roleName) throws UniqueConstraintViolationException;

    void editUser(User user);

    void addRoleToUser(Role role, User user);

    void removeRoleFromUser(Role role, User user);

    List<User> getAllUsers();

    User getUserByCredentials(String userName, String password);

    User getUserById(Long id);

    User getUserByEmail(String email);

    void sendPasswordChangeRequest(String passwordResetURL, User user);

    PasswordChangeRequest getPasswordChangeRequestById(String id);

    void removePasswordChangeRequest(String id);

}
