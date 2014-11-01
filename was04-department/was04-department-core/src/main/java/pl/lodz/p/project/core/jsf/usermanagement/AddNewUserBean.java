package pl.lodz.p.project.core.jsf.usermanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.service.account.AccountService;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "addNewUserBean")
@Scope("request")
public class AddNewUserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private AccountService accountManagementEndpoint;

    private List<RoleDTO> roleList;
    private RoleDTO selectedRole;
    private String email;

    public AddNewUserBean() {
        roleList = new ArrayList<>();
    }

    @PostConstruct
    public void initRoleList() {
        roleList = accountManagementEndpoint.getAllRoles();
    }

    /**
     * Sends an invitation mail to the given e-mail address.
     *
     */
    public void sendInvitation() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            if (selectedRole == null) {
                facesContext.addMessage(null, new FacesMessage("Błąd", "Należy wybrać rolę nowego użytkownika!"));
                return;
            }
            if (email.isEmpty()) {
                facesContext.addMessage(null, new FacesMessage("Błąd", "Należy podać adres e-mail!"));
                return;
            }
            if (accountManagementEndpoint.getUserByEmail(email) != null) {
                facesContext.addMessage(null, new FacesMessage("Błąd", "Konto o takim adresie e-mail już istnieje!"));
                return;
            }
            String registrationURL = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getRequestURL().toString();
            registrationURL = registrationURL.replace("admin/add-new-user.xhtml", "registration/registration.xhtml");
            accountManagementEndpoint.sendInvitation(registrationURL, email, selectedRole);
            facesContext.addMessage(null, new FacesMessage("Sukces", "Wysłano zaproszenie do rejestracji!"));
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage("Błąd", "Operacja nie powiodła się!"));
        }
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public RoleDTO getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(RoleDTO selectedRole) {
        this.selectedRole = selectedRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
