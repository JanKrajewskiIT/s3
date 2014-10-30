package pl.lodz.p.was04.department.core.jsf.usermanagement;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.was04.department.core.dto.account.UserDTO;
import pl.lodz.p.was04.department.core.service.account.AccountService;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "resetPasswordBean")
@Scope("request")
public class ResetPasswordBean {

    @Autowired
    private AccountService accountManagementService;

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
        // TODO change id to long
        //passwordChangeRequestDTO = accountManagementService.getPasswordChangeRequestById(id);
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
            accountManagementService.editUserPassword(userDTO);
            accountManagementService.removePasswordChangeRequest(passwordChangeRequestDTO.getId());
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
