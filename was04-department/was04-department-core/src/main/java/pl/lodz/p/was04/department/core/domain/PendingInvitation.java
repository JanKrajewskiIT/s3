package pl.lodz.p.was04.department.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Persistable;

/**
 *
 * @author Łukasz Gadomski
 */
@Entity
@Table(name = "pending_invitations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PendingInvitation.findAll", query = "SELECT p FROM PendingInvitation p"),
    @NamedQuery(name = "PendingInvitation.findByInvitationId", query = "SELECT p FROM PendingInvitation p WHERE p.id = :id"),
    @NamedQuery(name = "PendingInvitation.findByEmail", query = "SELECT p FROM PendingInvitation p WHERE p.email = :email"),
    @NamedQuery(name = "PendingInvitation.findByToken", query = "SELECT p FROM PendingInvitation p WHERE p.token = :token"),
    @NamedQuery(name = "PendingInvitation.findByCreationDate", query = "SELECT p FROM PendingInvitation p WHERE p.creationDate = :creationDate")})
public class PendingInvitation implements Serializable, Persistable<Long> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "PENDING_INVITATIONS_SEQ", sequenceName = "pending_invitations_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PENDING_INVITATIONS_SEQ")
    @Column(name = "invitation_id")
    private Long id;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role role;

    public PendingInvitation() {
    }

    public PendingInvitation(Long id) {
        this.id = id;
    }

    public PendingInvitation(Long id, String email, String token, Date creationDate) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.creationDate = creationDate;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setInvitationId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        if (!(object instanceof PendingInvitation)) {
            return false;
        }
        PendingInvitation other = (PendingInvitation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.PendingInvitations[ invitationId=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
