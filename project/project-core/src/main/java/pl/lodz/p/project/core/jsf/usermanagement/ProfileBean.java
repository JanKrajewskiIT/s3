package pl.lodz.p.project.core.jsf.usermanagement;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.OptLockException;
import pl.lodz.p.project.core.service.account.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "profileBean")
@Scope("view")
public class ProfileBean implements Serializable {

	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileBean.class);

	@Autowired 
	private UserService userService;

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

    @PostConstruct
    public void init() {
        userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        userDTO = userService.getUserByEmail(userName);
    }

    public void changePassword() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!newPassword.equals(repeatPassword)) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Wprowadzone hasłą różnią się!"));
            return;
        }
        if (!userDTO.getPassword().equals(DigestUtils.sha256Hex(currentPassword))) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Podane hasło jest nieprawidłowe!"));
            return;
        }
        try {
            userDTO.setPassword(newPassword);
            userService.editUserPassword(userDTO);
            userDTO = userService.getUserByEmail(userName);
            facesContext.addMessage(null, new FacesMessage("Sukces", "Hasło zostało zmienione!"));
            LOGGER.info("Password changed for user: " + userName);
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
            userService.editUserEmailAddress(userDTO);
            userDTO = userService.getUserByEmail(userName);
            facesContext.addMessage(null, new FacesMessage("Sukces", "Adres e-mail został zmieniony!"));
            LOGGER.info("E-mail address changed for user: " + userName + ". New address: " + newEmail);
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
