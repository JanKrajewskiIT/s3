package pl.lodz.p.project.core.domain.account;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.lodz.p.project.core.domain.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

/**
*
* @author Janiu, Milczu
*/
@Entity
@Table(name = "users")
@NamedQuery(name = User.NAMED_QUERY_FIND_BY_EMAIL, query = "SELECT u from User u WHERE u.email = :email")
public class User extends BaseEntity<Long> implements UserDetails {

	private static final long serialVersionUID = 1L;
	public static final String NAMED_QUERY_FIND_BY_EMAIL = "User.findByEmail";
	private static final RoleToGrantedAuthorityTransformer ROLE_TRANSFORMER = new RoleToGrantedAuthorityTransformer();

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

	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		return Collections2.transform(rolesCollection, ROLE_TRANSFORMER);
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

	public Collection<Role> getRolesCollection() {
		return rolesCollection;
	}

	public void setRolesCollection(Collection<Role> rolesCollection) {
		this.rolesCollection = rolesCollection;
	}


	/* These implementations made Collection.contains(Object o) method not work properly.
        Had to comment them out to make user roles management work again. */

//    @Override
//    public int hashCode() {
//        return HashCodeBuilder.reflectionHashCode(this);
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        return EqualsBuilder.reflectionEquals(this, object);
//    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

class RoleToGrantedAuthorityTransformer implements Function<Role, SimpleGrantedAuthority> {

	@Override
	public SimpleGrantedAuthority apply(Role role) {
		return role == null ? null : new SimpleGrantedAuthority(role.getName());
	}
	
}