package pl.lodz.p.was04.department.core.jsf.usermanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.endpoint.accountmanagement.AccountManagementEndpointLocal;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "userListBean")
@Scope("request")
public class UserListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private AccountManagementEndpointLocal accountManagementEndpoint;

    private List<UserDTO> userList;

    public UserListBean() {
        userList = new ArrayList<>();
    }

    @PostConstruct
    public void initUserList() {
        userList = accountManagementEndpoint.getAllUsers();
    }

    public void onEdit(RowEditEvent event) {
        UserDTO userDTO = (UserDTO) event.getObject();
        try {
            accountManagementEndpoint.editUser(userDTO);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Błąd", "Edycja nie powiodła się!"));
        }
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

}
