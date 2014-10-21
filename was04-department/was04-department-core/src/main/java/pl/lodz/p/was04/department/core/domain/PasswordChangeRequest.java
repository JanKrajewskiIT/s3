package pl.lodz.p.was04.department.core.domain;

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

import org.springframework.data.domain.Persistable;

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
public class PasswordChangeRequest implements Serializable, Persistable<String> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User user;

    public PasswordChangeRequest() {
    }

    public PasswordChangeRequest(String id) {
        this.id = id;
    }

    public PasswordChangeRequest(String id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasswordChangeRequest)) {
            return false;
        }
        PasswordChangeRequest other = (PasswordChangeRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.PasswordChangeRequest[ id=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
