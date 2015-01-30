package pl.lodz.p.project.core.dto.account;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.base.BaseDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * DTO class mapping entities of type {@link User}.
 *
 * @author Łukasz Gadomski, Janiu
 */
public class UserDTO extends BaseDTO<Long> implements Comparable<UserDTO> {

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

    private Set<RoleDTO> roleSet = new HashSet<>();

    private boolean admin;
    private boolean manager;
    private boolean user;

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
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
	
}
