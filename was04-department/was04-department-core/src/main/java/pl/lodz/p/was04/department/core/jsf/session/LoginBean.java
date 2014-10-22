package pl.lodz.p.was04.department.core.jsf.session;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.endpoint.accountmanagement.AccountManagementEndpointLocal;

/**
 * Named bean responsible for user authentication.
 *
 * @author Łukasz Gadomski
 */
@Named
@Scope("session")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AccountManagementEndpointLocal accountManagementEndpoint;

	private String userName;
	private String password;
	private UserDTO userDTO;

	public LoginBean() {
		userName = "";
		password = "";
	}

	/**
	 * Loads login page by returning navigation String.
	 *
	 * @return String - navigation String
	 */
	public String loadPage() {
		return "login";
	}

	/**
	 * Performs HttpServletRequest login.
	 *
	 * @return String - navigation String
	 */
	public String login() {
		// try {
		// HttpServletRequest request = (HttpServletRequest)
		// FacesContext.getCurrentInstance().getExternalContext().getRequest();
		// TODO library not contain such method
		// request.login(userName, password);
		userDTO = accountManagementEndpoint.getUserByEmail(userName);
		System.out.println("Zalogowano");
		return "index";
		// } catch (ServletException e) {
		// FacesContext.getCurrentInstance().addMessage(null, new
		// FacesMessage("Nieprawidłowy adres e-mail lub hasło!"));
		// }
		// return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * Checks if user is in the admin role.
	 *
	 * @return boolean
	 */
	public boolean isAccessLevelAdmin() {
		return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("admin");
	}

	/**
	 * Checks if user is in the manager role.
	 *
	 * @return boolean
	 */
	public boolean isAccessLevelManager() {
		return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("manager");
	}

	/**
	 * Checks if user is in the user role.
	 *
	 * @return boolean
	 */
	public boolean isAccessLevelUser() {
		return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("user");
	}

	/**
	 * Checks if user is a guest.
	 *
	 * @return boolean
	 */
	public boolean isGuest() {
		return (!isAccessLevelAdmin() && !isAccessLevelManager() && !isAccessLevelUser());
	}

}
