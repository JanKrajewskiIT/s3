package pl.lodz.p.was04.department.core.endpoint.accountmanagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.PasswordChangeRequest;
import pl.lodz.p.was04.department.core.domain.PendingInvitation;
import pl.lodz.p.was04.department.core.domain.Role;
import pl.lodz.p.was04.department.core.domain.User;
import pl.lodz.p.was04.department.core.dto.PasswordChangeRequestDTO;
import pl.lodz.p.was04.department.core.dto.PendingInvitationDTO;
import pl.lodz.p.was04.department.core.dto.RoleDTO;
import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.accountmanagement.AccountManagerLocal;

/**
 * EJB Stateful session bean serving as an endpoint for account management.
 *
 * @author Łukasz Gadomski
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class AccountManagementEndpoint implements AccountManagementEndpointLocal {

    @Autowired
    private AccountManagerLocal accountManager;

    private User originalUser;

    /**
     * Retrieves all roles from the DB and creates a list of DTO representing those roles. Invokes {@link AccountManagerLocal#getAllRoles()
     * }.
     *
     * @return the list of DTO represeting all roles found in the DB.
     */
    @RolesAllowed("accountManagement")
    @Override
    public List<RoleDTO> getAllRoles() {
        List<RoleDTO> roleList = new ArrayList<>();
        for (Role roleEntity : accountManager.getAllRoles()) {
            roleList.add(new RoleDTO(roleEntity));
        }
        return roleList;
    }

    @PermitAll
    @Override
    public RoleDTO getRoleByName(String roleName) {
        Role role = accountManager.getRoleByName(roleName);
        if (role != null) {
            return new RoleDTO(role);
        }
        return null;
    }

    /**
     * Sends an invitation mail to the given e-mail address. Invokes {@link AccountManagerLocal#sendInvitation(java.lang.String, java.lang.String, java.lang.Integer)
     * }.
     *
     * @param registrationURL the URL of registration page for given user.
     * @param email the e-mail address that the mail is to be sent to.
     * @param roleDTO the DTO representing the role that is to be added to a new user.
     */
    @RolesAllowed("accountManagement")
    @Override
    public void sendInvitation(String registrationURL, String email, RoleDTO roleDTO) {
        accountManager.sendInvitation(registrationURL, email, roleDTO.getRoleName());
    }

    /**
     * Retrieves a pending invitation with given token from the DB and creates a DTO representing it. Invokes {@link AccountManagerLocal#getPendingInvitationByToken(java.lang.String)
     * }.
     *
     * @param token the token of the searched pending invitation.
     * @return the DTO representing the found pending invitation.
     */
    @PermitAll
    @Override
    public PendingInvitationDTO getPendingInvitationByToken(String token) {
        PendingInvitation pendingInvitation = accountManager.getPendingInvitationByToken(token);
        if (pendingInvitation != null) {
            return new PendingInvitationDTO(pendingInvitation);
        }
        return null;
    }

    /**
     * Removes a pending invitation with given ID from the DB. Invokes {@link AccountManagerLocal#removePendingInvitation(java.lang.Integer)
     * }.
     *
     * @param id the ID of the pending invitation that is to be removed
     */
    @PermitAll
    @Override
    public void removePendingInvitation(Long id) {
        accountManager.removePendingInvitation(id);
    }

    /**
     * Retrieves all users from the DB and creates a list of DTO representing those users. Invokes {@link AccountManagerLocal#getAllUsers()
     * }
     *
     * @return the list of DTO represeting all users found in the DB.
     */
    @RolesAllowed("accountManagement")
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userList = new ArrayList<>();
        for (User userEntity : accountManager.getAllUsers()) {
            userList.add(new UserDTO(userEntity));
        }
        return userList;
    }

    /**
     * Creates a new user entity with given roles based on the given DTO and stores it in the DB. Invokes {@link AccountManagerLocal#createUser(pl.lodz.p.was04.headoffice.entity.User)
     * } and {@link AccountManagerLocal#addRoleToUser(pl.lodz.p.was04.headoffice.entity.Role, pl.lodz.p.was04.headoffice.entity.User)
     * } to store the user entity and add a role to it and {@link AccountManagerLocal#getRoleById(java.lang.Integer) }
     * to retrieve a role entity mapped by the roleDTO.
     *
     * @param userDTO the DTO representing a new user.
     * @throws pl.lodz.p.was04.headoffice.exception.UniqueConstraintViolationException
     */
    @PermitAll
    @Override
    public void createUser(UserDTO userDTO) throws UniqueConstraintViolationException {
        User user = new User(userDTO);
        user.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
        accountManager.createUser(user, userDTO.getRoleSet().iterator().next().getRoleName());
    }

    @RolesAllowed("accountManagement")
    @Override
    public void editUser(UserDTO userDTO) {
        getUserByEmail(userDTO.getEmail());
        Role adminRole = accountManager.getRoleByName("admin");
        Role managerRole = accountManager.getRoleByName("manager");
        Role userRole = accountManager.getRoleByName("user");
        /* admin */
        if (originalUser.getRolesCollection().contains(adminRole) && !userDTO.isAdmin()) {
            accountManager.removeRoleFromUser(adminRole, originalUser);
        } else if (!originalUser.getRolesCollection().contains(adminRole) && userDTO.isAdmin()) {
            accountManager.addRoleToUser(adminRole, originalUser);
        }
        /* manager */
        if (originalUser.getRolesCollection().contains(managerRole) && !userDTO.isManager()) {
            accountManager.removeRoleFromUser(managerRole, originalUser);
        } else if (!originalUser.getRolesCollection().contains(managerRole) && userDTO.isManager()) {
            accountManager.addRoleToUser(managerRole, originalUser);
        }
        /* user */
        if (originalUser.getRolesCollection().contains(userRole) && !userDTO.isUser()) {
            accountManager.removeRoleFromUser(userRole, originalUser);
        } else if (!originalUser.getRolesCollection().contains(userRole) && userDTO.isUser()) {
            accountManager.addRoleToUser(userRole, originalUser);
        }
    }

    @PermitAll
    @Override
    public void editUserPassword(UserDTO userDTO) {
        originalUser.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
        accountManager.editUser(originalUser);
    }

    @RolesAllowed("profileEdition")
    @Override
    public void editUserEmailAddress(UserDTO userDTO) {
        originalUser.setEmail(userDTO.getEmail());
        accountManager.editUser(originalUser);
    }

    /**
     * Retrieves a user with given e-mail address from the DB and creates a DTO based on the result. Invokes {@link AccountManagerLocal#getUserByEmail(java.lang.String)
     * }.
     *
     * @param email the email of the searched user.
     * @return the found user.
     */
    @PermitAll
    @Override
    public UserDTO getUserByEmail(String email) {
        originalUser = accountManager.getUserByEmail(email);
        if (originalUser != null) {
            return new UserDTO(originalUser);
        }
        return null;
    }

    @PermitAll
    @Override
    public void sendPasswordChangeRequest(String passwordResetURL, String email) {
        User user = accountManager.getUserByEmail(email);
        accountManager.sendPasswordChangeRequest(passwordResetURL, user);
    }

    @PermitAll
    @Override
    public PasswordChangeRequestDTO getPasswordChangeRequestById(String id) {
        PasswordChangeRequest passwordChangeRequest = accountManager.getPasswordChangeRequestById(id);
        if (passwordChangeRequest != null) {
            return new PasswordChangeRequestDTO(passwordChangeRequest);
        }
        return null;
    }

    @PermitAll
    @Override
    public void removePasswordChangeRequest(String id) {
        accountManager.removePasswordChangeRequest(id);
    }

}
