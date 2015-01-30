package pl.lodz.p.project.core.jsf.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.RoleDTO;
import pl.lodz.p.project.core.service.account.PendingInvitationService;
import pl.lodz.p.project.core.service.account.RoleService;
import pl.lodz.p.project.core.service.account.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "addNewUserBean")
@Scope("request")
public class AddNewUserBean implements Serializable {

	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(AddNewUserBean.class);

	@Autowired 
	private UserService userService;

	@Autowired 
	private RoleService roleService;

	@Autowired 
	private PendingInvitationService pendingInvitationService;
	
    private List<RoleDTO> roleList;
    private RoleDTO selectedRole;
    private String email;

    public AddNewUserBean() {
        roleList = new ArrayList<>();
    }

    @PostConstruct
    public void initRoleList() {
        roleList = roleService.getAll();
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
            if (userService.getUserByEmail(email) != null) {
                facesContext.addMessage(null, new FacesMessage("Błąd", "Konto o takim adresie e-mail już istnieje!"));
                return;
            }
            String registrationURL = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getRequestURL().toString();
            registrationURL = registrationURL.replace("admin/add-new-user.xhtml", "registration/registration.xhtml");
            pendingInvitationService.sendInvitation(registrationURL, email, selectedRole);
            facesContext.addMessage(null, new FacesMessage("Sukces", "Wysłano zaproszenie do rejestracji!"));
        } catch (Exception e) {
            LOGGER.error("Failed to send an account invitation!", e);
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
