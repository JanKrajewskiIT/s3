package pl.lodz.p.was04.department.core.jsf.usermanagement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.endpoint.accountmanagement.AccountManagementEndpointLocal;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "forgotPasswordBean")
@Scope("request")
public class ForgotPasswordBean {

    @Autowired
    private AccountManagementEndpointLocal accountManagementEndpoint;

    private String email;

    public void createRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (email == null || email.isEmpty()) {
            facesContext.addMessage(null, new FacesMessage("Należy podać adres e-mail!"));
            return;
        }
        UserDTO userDTO = accountManagementEndpoint.getUserByEmail(email);
        if (userDTO == null) {
            facesContext.addMessage(null, new FacesMessage("Konto o podanym adresie e-mail nie istnieje!"));
            return;
        }
        try {
            String passwordResetURL = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getRequestURL().toString();
            passwordResetURL = passwordResetURL.replace("forgot-password.xhtml", "reset-password.xhtml");
            facesContext.addMessage(null, new FacesMessage("Na podany adres e-mail wysłano wiadomość z dalszymy instrukcjami!"));
            accountManagementEndpoint.sendPasswordChangeRequest(passwordResetURL, email);
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
