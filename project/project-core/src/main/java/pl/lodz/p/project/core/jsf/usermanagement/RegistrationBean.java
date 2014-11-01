package pl.lodz.p.project.core.jsf.usermanagement;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;
import pl.lodz.p.project.core.service.account.AccountService;

/**
 * View scoped bean responsible for user registration.
 *
 * @author Łukasz Gadomski
 */
@Named(value = "registrationBean")
@Scope("request")
public class RegistrationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private AccountService accountManagementService;

    private UserDTO userDTO;
    private PendingInvitationDTO pendingInvitationDTO;
    private String token;
    private String repeatPassword;

    public RegistrationBean() {
        userDTO = new UserDTO();
    }

    /**
     * Initializes the bean. Reads the token from the request parameter map. If there is a pending invitation with given
     * token in the DB the registration form is displayed. Otherwise the browser is redirected to the 404 page. Invokes {@link AccountService#getPendingInvitationByToken(java.lang.String)
     * }.
     *
     */
    @PostConstruct
    public void initRegistration() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        token = facesContext.getExternalContext().getRequestParameterMap().get("token");
        if (token == null) {
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "404");
            return;
        }
        pendingInvitationDTO = accountManagementService.getPendingInvitationByToken(token);
        if (pendingInvitationDTO == null) {
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "404");
        }
    }

    /**
     * Performs the registration of a user. Invokes {@link AccountService#createUser(pl.lodz.p.was04.department.core.dto.account.headoffice.dto.UserDTO)
     * }.
     *
     */
    public void register() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!repeatPassword.equals(userDTO.getPassword())) {
            facesContext.addMessage(null, new FacesMessage("Podane hasła różnią się!"));
            return;
        }
        try {
            userDTO.setEmail(pendingInvitationDTO.getEmail());
            userDTO.getRoleSet().add(pendingInvitationDTO.getRole());
            //TODO userDTO.setActive(true);
            accountManagementService.createUser(userDTO);
            accountManagementService.removePendingInvitation(pendingInvitationDTO.getId());
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "registrationSuccess");
        } catch (UniqueConstraintViolationException e) {
            facesContext.addMessage(null, new FacesMessage("Istnieje już konto o danym adresie e-mail!"));
        }
    }

    public PendingInvitationDTO getPendingInvitationDTO() {
        return pendingInvitationDTO;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    
}