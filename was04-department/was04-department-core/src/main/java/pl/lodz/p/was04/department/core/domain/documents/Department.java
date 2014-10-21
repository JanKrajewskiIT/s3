package pl.lodz.p.was04.department.core.domain.documents;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.documents.DepartmentDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "departments")
@XmlRootElement
public class Department implements Serializable, Activable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "department_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "department_name")
    private String departmentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private Collection<WarehouseDocument> warehouseDocumentsCollection;

    public Department() {
    }

    public Department(Long id) {
        this.id = id;
    }

    public Department(Long id, String departmentName, boolean active, long version) {
        this.id = id;
        this.departmentName = departmentName;
        this.active = active;
        this.version = version;
    }
    
    public Department(DepartmentDTO department){
        this.departmentName = department.getDepartmentName();
        this.id = department.getId();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<WarehouseDocument> getWarehouseDocumentsCollection() {
        return warehouseDocumentsCollection;
    }

    public void setWarehouseDocumentsCollection(Collection<WarehouseDocument> warehouseDocumentsCollection) {
        this.warehouseDocumentsCollection = warehouseDocumentsCollection;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.Departments[ departmentId=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
    
}