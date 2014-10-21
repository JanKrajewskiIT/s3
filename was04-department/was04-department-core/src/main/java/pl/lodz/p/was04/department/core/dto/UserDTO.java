package pl.lodz.p.was04.department.core.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.Role;
import pl.lodz.p.was04.department.core.domain.User;

/**
 * DTO class mapping entities of type {@link User}.
 *
 * @author Łukasz Gadomski
 */
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Hasło nie może być puste!")
    @Size(min = 6, max = 64, message = "Hasło musi zawierać minimum 6 znaków!")
    private String password;
    @NotNull(message = "Podaj imię!")
    private String firstName;
    @NotNull(message = "Podaj nazwisko!")
    private String secondName;
    @NotNull(message = "Adres e-mail nie może być pusty!")
    private String email;
    private boolean active;
    private Set<RoleDTO> roleSet;

    private boolean admin;
    private boolean manager;
    private boolean user;

    public UserDTO() {
        roleSet = new HashSet<>();
    }

    public UserDTO(User user) {
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.email = user.getEmail();
        this.active = user.isActive();
        this.roleSet = new HashSet<>();
        for (Role role : user.getRolesCollection()) {
            this.roleSet.add(new RoleDTO(role));
            if (role.getRoleName().equalsIgnoreCase("admin")) {
                this.admin = true;
            } else if (role.getRoleName().equalsIgnoreCase("manager")) {
                this.manager = true;
            } else if (role.getRoleName().equalsIgnoreCase("user")) {
                this.user = true;
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RoleDTO> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<RoleDTO> roleSet) {
        this.roleSet = roleSet;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.firstName);
        hash = 71 * hash + Objects.hashCode(this.secondName);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + (this.active ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.roleSet);
        hash = 71 * hash + (this.admin ? 1 : 0);
        hash = 71 * hash + (this.manager ? 1 : 0);
        hash = 71 * hash + (this.user ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDTO other = (UserDTO) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.secondName, other.secondName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.roleSet, other.roleSet)) {
            return false;
        }
        if (this.admin != other.admin) {
            return false;
        }
        if (this.manager != other.manager) {
            return false;
        }
        if (this.user != other.user) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
