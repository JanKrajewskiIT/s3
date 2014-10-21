package pl.lodz.p.was04.department.core.jsf.usermanagement;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.PasswordChangeRequestDTO;
import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.endpoint.accountmanagement.AccountManagementEndpointLocal;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "resetPasswordBean")
@Scope("view")
public class ResetPasswordBean {

    @Autowired
    private AccountManagementEndpointLocal accountManagementEndpoint;

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
        passwordChangeRequestDTO = accountManagementEndpoint.getPasswordChangeRequestById(id);
        if (passwordChangeRequestDTO == null) {
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "404");
            return;
        }
        userDTO = passwordChangeRequestDTO.getUserDTO();
    }

    public String changePassword() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!newPassword.equals(repeatPassword)) {
            facesContext.addMessage(null, new FacesMessage("Wprowadzone hasłą różnią się!"));
            return null;
        }
        try {
            userDTO.setPassword(newPassword);
            accountManagementEndpoint.editUserPassword(userDTO);
            accountManagementEndpoint.removePasswordChangeRequest(passwordChangeRequestDTO.getId());
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
