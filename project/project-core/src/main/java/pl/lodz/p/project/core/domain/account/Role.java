package pl.lodz.p.project.core.domain.account;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.base.NamedEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

/**
 *
 * @author Łukasz Gadomski, Janiu
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = Role.NAMED_QUERY_FIND_BY_NAME, query = "SELECT r FROM Role r WHERE r.name = :name")
public class Role extends NamedEntity<Long> {

    private static final long serialVersionUID = 1L;
	public static final String NAMED_QUERY_FIND_BY_NAME = "Role.findByRoleName";

    @JoinTable(name = "users_roles", joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> usersCollection;

	@XmlTransient
    public Collection<User> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<User> usersCollection) {
        this.usersCollection = usersCollection;
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