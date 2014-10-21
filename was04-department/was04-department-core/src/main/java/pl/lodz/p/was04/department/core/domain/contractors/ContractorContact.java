package pl.lodz.p.was04.department.core.domain.contractors;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.domain.Persistable;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorContactDTO;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "contractors_contacts")
public class ContractorContact implements Serializable, Persistable<Long> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractor_contact_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "number")
    private String number;
    @Column(name = "is_default")
    private Boolean isDefault;
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor contractor;

    public ContractorContact() {
    }

    public ContractorContact(Long id) {
        this.id = id;
    }

    public ContractorContact(ContractorContactDTO contractorContact) {
        this.id = contractorContact.getId();
        this.name = contractorContact.getName();
        this.number = contractorContact.getNumber();
        this.isDefault = contractorContact.isDefault();
        this.contractor = contractorContact.getContractor();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
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
        if (!(object instanceof ContractorContact)) {
            return false;
        }
        ContractorContact other = (ContractorContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.contractors.ContractorsContacts[ id=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
