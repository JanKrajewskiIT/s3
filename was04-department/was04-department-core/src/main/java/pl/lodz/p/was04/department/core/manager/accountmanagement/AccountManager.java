package pl.lodz.p.was04.department.core.manager.accountmanagement;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.UserDao;
import pl.lodz.p.was04.department.core.dao.accountmanagement.PasswordChangeRequestDao;
import pl.lodz.p.was04.department.core.dao.accountmanagement.PendingInvitationDao;
import pl.lodz.p.was04.department.core.dao.accountmanagement.RoleDao;
import pl.lodz.p.was04.department.core.domain.PasswordChangeRequest;
import pl.lodz.p.was04.department.core.domain.PendingInvitation;
import pl.lodz.p.was04.department.core.domain.Role;
import pl.lodz.p.was04.department.core.domain.User;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;
import pl.lodz.p.was04.department.core.utils.MailSender;

/**
 *
 * @author Łukasz Gadomski
 */
@Component
public class AccountManager implements AccountManagerLocal {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private PendingInvitationDao pendingInvitationDao;
    
    @Autowired
    private MailSender mailSender;
    
    @Autowired
    private PasswordChangeRequestDao passwordChangeRequestDao;

    /**
     * Retrieves all roles from the DB. Invokes {@link RoleFacadeLocal#findAll() }.
     *
     * @return the list of all roles found in the DB.
     */
    @RolesAllowed("accountManagement")
    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    /**
     * Retrieves a role with given ID from the DB. Invokes {@link RoleFacadeLocal#find(java.lang.Object) }.
     *
     * @param id the ID of searched role.
     * @return the found role.
     */
    @PermitAll
    @Override
    public Role getRoleById(Long id) {
        return roleDao.findOne(id);
    }

    /**
     * Retrieves a role with given name from the DB. Invokes {@link RoleFacadeLocal#findByName(java.lang.String) }.
     *
     * @param roleName the name of searched role.
     * @return the found role.
     */
    @RolesAllowed("accountManagement")
    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.findByName(roleName);
    }

    /**
     * Sends an invitation mail to the given e-mail address. Invokes {@link MailSender#sendInvitationMail(java.lang.String, java.lang.String, pl.lodz.p.was04.headoffice.entity.Role)
     * }.
     *
     * @param registrationURL the URL of registration page for given user.
     * @param email the e-mail address that the mail is to be sent to.
     * @param roleName the name of the role that is to be added to a new user.
     */
    @RolesAllowed("accountManagement")
    @Override
    public void sendInvitation(String registrationURL, String email, String roleName) {
        mailSender.sendInvitationMail(registrationURL, email, roleDao.findByName(roleName));
    }

    /**
     * Retrieves a pending invitation with given token from the DB. Invokes {@link PendingInvitationFacadeLocal#findByToken(java.lang.String)
     * }.
     *
     * @param token the token to be searched by.
     * @return the found pending invitation.
     */
    @PermitAll
    @Override
    public PendingInvitation getPendingInvitationByToken(String token) {
        return pendingInvitationDao.findByToken(token);
    }

    /**
     * Removes a pending invitation with given ID from the DB. Invokes {@link PendingInvitationFacadeLocal#find(java.lang.Object)
     * }
     * to find the pending invitation and {@link PendingInvitationFacadeLocal#remove(pl.lodz.p.was04.headoffice.entity.PendingInvitation)
     * } to remove it.
     *
     * @param id the ID of the pending invitation that is to be removed.
     */
    @PermitAll
    @Override
    public void removePendingInvitation(Long id) {
        pendingInvitationDao.delete(pendingInvitationDao.findOne(id));
    }

    /**
     * Stores a new user in the DB. Invokes {@link UserFacadeLocal#create(pl.lodz.p.was04.headoffice.entity.User) } to
     * store the user and {@link UserFacadeLocal#flush() to synchronize persistence context with the DB}.
     *
     * @param user the user to be stored in the DB.
     * @param roleId
     * @throws pl.lodz.p.was04.headoffice.exception.UniqueConstraintViolationException
     */
    @PermitAll
    @Override
    public void createUser(User user, String roleName) throws UniqueConstraintViolationException {
        Role role = getRoleByName(roleName);
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
        userDao.save(user);
        userDao.flush();
        roleDao.save(role);
    }

    @PermitAll
    @Override
    public void editUser(User user) {
        userDao.save(user);
        userDao.flush();
    }

    /**
     * Adds a given role to the given user. Invokes {@link UserFacadeLocal#edit(pl.lodz.p.was04.headoffice.entity.User)
     * } and {@link RoleFacadeLocal#edit(pl.lodz.p.was04.headoffice.entity.Role) }.
     *
     * @param role the role to be added.
     * @param user the user to receive the role.
     */
    @RolesAllowed("accountManagement")
    @Override
    public void addRoleToUser(Role role, User user) {
        user.getRolesCollection().add(role);
        role.getUsersCollection().add(user);
        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * Removes a given role from the given user. Invokes {@link UserFacadeLocal#edit(pl.lodz.p.was04.headoffice.entity.User)
     * } and {@link RoleFacadeLocal#edit(pl.lodz.p.was04.headoffice.entity.Role) }.
     *
     * @param role the role to be removed.
     * @param user the user to lose the role.
     */
    @RolesAllowed("accountManagement")
    @Override
    public void removeRoleFromUser(Role role, User user) {
        user.getRolesCollection().remove(role);
        role.getUsersCollection().remove(user);
        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * Retrieves all users from the DB. Invokes {@link UserFacadeLocal#findAll() }.
     *
     * @return the list of all users found in the DB.
     */
    @RolesAllowed("accountManagement")
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserByCredentials(String userName, String password) {
        return userDao.findByCredentials(userName, password);
    }

    /**
     * Retrieves a user with given ID from the DB. Invokes {@link UserFacadeLocal#find(java.lang.Object) }.
     *
     * @param id the ID of the searched user.
     * @return the found user.
     */
    @PermitAll
    @Override
    public User getUserById(Long id) {
        return userDao.findOne(id);
    }

    /**
     * Retrieves a user with given login from the DB. Invokes {@link UserFacadeLocal#findByEmail(java.lang.String) }.
     *
     * @param email the email of the searched user.
     * @return the found user.
     */
    @PermitAll
    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @PermitAll
    @Override
    public void sendPasswordChangeRequest(String passwordResetURL, User user) {
        mailSender.sendPasswordChangeRequestMail(passwordResetURL, user);
    }

    @PermitAll
    @Override
    public PasswordChangeRequest getPasswordChangeRequestById(String id) {
        return passwordChangeRequestDao.findOne(id);
    }

    @PermitAll
    @Override
    public void removePasswordChangeRequest(String id) {
        passwordChangeRequestDao.delete(passwordChangeRequestDao.findOne(id));
    }

}
