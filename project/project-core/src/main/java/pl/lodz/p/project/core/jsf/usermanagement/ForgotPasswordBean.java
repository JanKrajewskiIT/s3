package pl.lodz.p.project.core.jsf.usermanagement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.service.account.PasswordChangeRequestService;
import pl.lodz.p.project.core.service.account.UserService;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "forgotPasswordBean")
@Scope("request")
public class ForgotPasswordBean {

	@Autowired 
	private UserService userService;

	@Autowired 
	private PasswordChangeRequestService passwordChangeRequestService;

    private String email;

    public void createRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (email == null || email.isEmpty()) {
            facesContext.addMessage(null, new FacesMessage("Należy podać adres e-mail!"));
            return;
        }
        UserDTO userDTO = userService.getUserByEmail(email);
        if (userDTO == null) {
            facesContext.addMessage(null, new FacesMessage("Konto o podanym adresie e-mail nie istnieje!"));
            return;
        }
        try {
            String passwordResetURL = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getRequestURL().toString();
            passwordResetURL = passwordResetURL.replace("forgot-password.xhtml", "reset-password.xhtml");
            facesContext.addMessage(null, new FacesMessage("Na podany adres e-mail wysłano wiadomość z dalszymy instrukcjami!"));
            passwordChangeRequestService.sendPasswordChangeRequest(passwordResetURL, email);
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Operacja nie powiodła się!"));
        }
    }

    public ForgotPasswordBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
