package pl.lodz.p.project.core.jsf.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.PendingInvitationDTO;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;
import pl.lodz.p.project.core.service.account.PendingInvitationService;
import pl.lodz.p.project.core.service.account.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * View scoped bean responsible for user registration.
 *
 * @author Łukasz Gadomski
 */
@Named(value = "registrationBean")
@Scope("view")
public class RegistrationBean implements Serializable {

	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationBean.class);

	@Autowired 
	private UserService userService;

	@Autowired 
	private PendingInvitationService pendingInvitationService;

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
            LOGGER.error("No token passed. Redirecting to 404 error page!");
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "404");
            return;
        }
        pendingInvitationDTO = pendingInvitationService.getOneByToken(token);
        if (pendingInvitationDTO == null) {
            LOGGER.error("There is no matching pedning invitation for token " + token + ". Redirecting to 404 error page!");
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
            userDTO.setActive(true);
            userService.createUser(userDTO);
            pendingInvitationService.delete(pendingInvitationDTO.getId());
            facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "registrationSuccess");
        } catch (UniqueConstraintViolationException e) {
            LOGGER.error("Failed to register new account!",e);
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
