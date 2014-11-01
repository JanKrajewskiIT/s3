package pl.lodz.p.project.core.dto.account;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.domain.account.User;

import com.google.common.collect.ComparisonChain;

/**
 * DTO class mapping entities of type {@link User}.
 *
 * @author Łukasz Gadomski, Janiu
 */
public class UserDTO implements Serializable, Comparable<UserDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull(message = "Hasło nie może być puste!")
    @Size(min = 6, max = 64, message = "Hasło musi zawierać minimum 6 znaków!")
    private String password;
	
    @NotNull(message = "Podaj imię!")
    private String firstName;
    
    @NotNull(message = "Podaj nazwisko!")
    private String secondName;
    
    @NotNull(message = "Adres e-mail nie może być pusty!")
    private String email;
    
    private Set<RoleDTO> roleSet;

    private boolean admin;
    private boolean manager;
    private boolean user;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(UserDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}
	
}
