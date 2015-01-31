package pl.lodz.p.project.core.jsf.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.service.account.PasswordChangeRequestService;
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
@Named(value = "resetPasswordBean")
@Scope("view")
public class ResetPasswordBean implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResetPasswordBean.class);

	@Autowired 
	private UserService userService;

	@Autowired 
	private PasswordChangeRequestService passwordChangeRequestService;

    private UserDTO userDTO;
    private PasswordChangeRequestDTO passwordChangeRequestDTO;
    private String newPassword;
    private String repeatPassword;
    private String id;

    @PostConstruct
    public void initPasswordReset() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        id = facesContext.getExternalContext().getRequestParameterMap().get("id");
        if (id == null || id.isEmpty()) {
            facesContext.getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "404");
            return;
        }
        try {
            passwordChangeRequestDTO = passwordChangeRequestService.getOneById(Long.parseLong(id));
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid ID passed to reset-password page: " + id);
        }
        if (passwordChangeRequestDTO == null) {
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "404");
            return;
        }
        userDTO = passwordChangeRequestDTO.getUser();
    }

    public String changePassword() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!newPassword.equals(repeatPassword)) {
            facesContext.addMessage(null, new FacesMessage("Wprowadzone hasłą różnią się!"));
            return null;
        }
        try {
            userDTO.setPassword(newPassword);
            userService.editUserPassword(userDTO);
            passwordChangeRequestService.delete(passwordChangeRequestDTO.getId());
            return "passwordresetsuccess";
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage("Zmiana hasła nie powiodłą się!"));
            return null;
        }
    }

    /**
     * Creates a new instance of ResetPasswordBean
     */
    public ResetPasswordBean() {
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

}
