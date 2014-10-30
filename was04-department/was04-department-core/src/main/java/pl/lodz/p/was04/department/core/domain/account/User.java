package pl.lodz.p.was04.department.core.domain.account;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.lodz.p.was04.department.core.domain.BasePersistable;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
*
* @author Janiu, Milczu
*/
@Entity
@Table(name = "users")
@NamedQuery(name = User.NAMED_QUERY_FIND_BY_EMAIL, query = "SELECT u from User u WHERE u.email = :email")
public class User implements UserDetails, BasePersistable {

	public static final String NAMED_QUERY_FIND_BY_EMAIL = "User.findByEmail";

	private static final long serialVersionUID = 861141317002943612L;
	
	private static final RoleToGrantedAuthorityTransformer ROLE_TRANSFORMER = new RoleToGrantedAuthorityTransformer();

	@Id
	@SequenceGenerator(name = "users_sequence", sequenceName = "users_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	@Column(name = "user_id")
	private Long id;

	@Column(length = 64, nullable = false)
	private String password;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "first_name")
	private String firstName;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "second_name")
	private String secondName;

	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	private String email;

	@ManyToMany(mappedBy = "usersCollection", fetch = FetchType.EAGER)
	private Collection<Role> rolesCollection = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<PasswordChangeRequest> passwordChangeRequestCollection = new ArrayList<>();

	@Basic(optional = false)
	@NotNull
	@Column(name = "is_active")
	private Boolean active = true;
	
	@Version
	private Long version = 1L;

	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		return Collections2.transform(rolesCollection, ROLE_TRANSFORMER);
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Collection<Role> getRolesCollection() {
		return rolesCollection;
	}

	public void setRolesCollection(Collection<Role> rolesCollection) {
		this.rolesCollection = rolesCollection;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	@XmlTransient
	public Collection<PasswordChangeRequest> getPasswordChangeRequestCollection() {
		return passwordChangeRequestCollection;
	}

	public void setPasswordChangeRequestCollection(
			Collection<PasswordChangeRequest> passwordChangeRequestCollection) {
		this.passwordChangeRequestCollection = passwordChangeRequestCollection;
	}

	@Override
	public boolean isNew() {
		return id == null;
	}

}

class RoleToGrantedAuthorityTransformer implements Function<Role, SimpleGrantedAuthority> {

	@Override
	public SimpleGrantedAuthority apply(Role role) {
		return role == null ? null : new SimpleGrantedAuthority(role.getName());
	}
	
}
