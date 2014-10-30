package pl.lodz.p.was04.department.core.domain.account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.BasePersistable;

/**
 *
 * @author Łukasz Gadomski
 */
@Entity
@Table(name = "password_change_requests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasswordChangeRequest.findAll", query = "SELECT p FROM PasswordChangeRequest p"),
    @NamedQuery(name = "PasswordChangeRequest.findById", query = "SELECT p FROM PasswordChangeRequest p WHERE p.id = :id"),
    @NamedQuery(name = "PasswordChangeRequest.findByCreationDate", query = "SELECT p FROM PasswordChangeRequest p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "PasswordChangeRequest.findByUser", query = "SELECT p FROM PasswordChangeRequest p WHERE p.user = :user")})
public class PasswordChangeRequest implements Serializable, BasePersistable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password_change_request_id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)    
    private Date creationDate;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)    
    private User user;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
	public boolean isNew() {
		return id == null;
	}

}