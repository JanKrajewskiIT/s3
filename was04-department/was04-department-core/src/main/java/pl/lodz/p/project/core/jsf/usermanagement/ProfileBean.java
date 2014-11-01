package pl.lodz.p.project.core.jsf.usermanagement;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.OptLockException;
import pl.lodz.p.project.core.service.account.AccountService;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "profileBean")
@Scope("session")
public class ProfileBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private AccountService accountManagementEndpoint;

    private UserDTO userDTO;
    private String userName;
    private String newPassword;
    private String repeatPassword;
    private String currentPassword;
    private String newEmail;
    private String repeatEmail;
    private String emailPassword;

    public ProfileBean() {
    }

    public String initProfile(String userName) {
        this.userName = userName;
        userDTO = accountManagementEndpoint.getUserByEmail(userName);
        return "profile";
    }

    public void changePassword() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!newPassword.equals(repeatPassword)) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Wprowadzone hasłą różnią się!"));
            return;
        }
        if (!userDTO.getPassword().equals(DigestUtils.sha256Hex(currentPassword))) {
            System.out.println("HASŁO = " + userDTO.getPassword());
            System.out.println("NIE HASH" + currentPassword);
            System.out.println("DRUGIE HASŁO = " + DigestUtils.sha256Hex(currentPassword));
            facesContext.addMessage(null, new FacesMessage("Błąd", "Podane hasło jest nieprawidłowe!"));
            return;
        }
        try {
            userDTO.setPassword(newPassword);
            accountManagementEndpoint.editUserPassword(userDTO);
            userDTO = accountManagementEndpoint.getUserByEmail(userName);
            facesContext.addMessage(null, new FacesMessage("Sukces", "Hasło zostało zmienione!"));
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Edycja nie powiodłą się!"));
        }
    }

    public void changeEmailAddress() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!newEmail.equals(repeatEmail)) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Wprowadzone adresy e-mail różnią się!"));
            return;
        }
        if (!userDTO.getPassword().equals(DigestUtils.sha256Hex(emailPassword))) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Podane hasło jest nieprawidłowe!"));
            return;
        }
        try {
            userDTO.setEmail(newEmail);
            accountManagementEndpoint.editUserEmailAddress(userDTO);
            userDTO = accountManagementEndpoint.getUserByEmail(userName);
            facesContext.addMessage(null, new FacesMessage("Sukces", "Adres e-mail został zmieniony!"));
        } catch (OptLockException ole) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Edycja nie powiodła się z powodu równoległej edycji!"));
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Edycja nie powiodła się!"));
        }
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getRepeatEmail() {
        return repeatEmail;
    }

    public void setRepeatEmail(String repeatEmail) {
        this.repeatEmail = repeatEmail;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

}
