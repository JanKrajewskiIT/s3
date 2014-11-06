package pl.lodz.p.project.core.jsf.usermanagement;

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

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.service.account.UserService;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "userListBean")
@Scope("request")
public class UserListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired 
	private UserService userService;

    private List<UserDTO> userList;

    public UserListBean() {
        userList = new ArrayList<>();
    }

    @PostConstruct
    public void initUserList() {
        userList = userService.getAll();
    }

    public void onEdit(RowEditEvent event) {
        UserDTO userDTO = (UserDTO) event.getObject();
        try {
        	userService.editUser(userDTO);
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
