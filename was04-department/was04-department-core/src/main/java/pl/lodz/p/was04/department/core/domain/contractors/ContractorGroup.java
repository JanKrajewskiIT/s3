package pl.lodz.p.was04.department.core.domain.contractors;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorGroupDTO;

/**
 *
 * @author Janiu, milczu
 */
@Entity
@Table(name = "contractors_groups")
public class ContractorGroup implements Serializable, Activable {
    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contractor_group_id")
    private Long id;
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active = true;
    @Version
    private Long version = 1L;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractorGroup")
    private Collection<Contractor> contractorsCollection;

    public ContractorGroup() {
    }

    public ContractorGroup(Long id) {
        this.id = id;
    }

    public ContractorGroup(ContractorGroupDTO contractorGroup) {
        this.id = contractorGroup.getId();
        this.name = contractorGroup.getName();
        this.active = contractorGroup.isActive();
        this.version = contractorGroup.getVersion();
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

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<Contractor> getContractorsCollection() {
        return contractorsCollection;
    }

    public void setContractorsCollection(Collection<Contractor> contractorsCollection) {
        this.contractorsCollection = contractorsCollection;
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
        if (!(object instanceof ContractorGroup)) {
            return false;
        }
        ContractorGroup other = (ContractorGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.contractors.ContractorGroup[ id=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
