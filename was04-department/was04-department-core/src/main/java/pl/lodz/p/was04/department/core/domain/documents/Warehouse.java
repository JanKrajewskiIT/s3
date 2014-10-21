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
import org.springframework.data.domain.Persistable;
import pl.lodz.p.was04.department.core.dto.documents.WarehouseDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "warehouses")
@XmlRootElement
public class Warehouse implements Serializable, Persistable<Long> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "warehouse_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "warehouse_name")
    private String warehouseName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "warehouse_short_name")
    private String warehouseShortName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_default")
    private boolean isDefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse")
    private Collection<SaleDocument> saleDocumentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouses")
    private Collection<WarehouseDocument> warehouseDocumentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouses")
    private Collection<DocumentPosition> documentsPositionsCollection;

    public Warehouse() {
    }

    public Warehouse(Long id) {
        this.id = id;
    }

    public Warehouse(Long id, String warehouseName, String warehouseShortName, boolean isDefault, long version) {
        this.id = id;
        this.warehouseName = warehouseName;
        this.warehouseShortName = warehouseShortName;
        this.isDefault = isDefault;
        this.version = version;
    }

    public Warehouse(WarehouseDTO warehouseDTO) {
        this.id = warehouseDTO.getId();
        this.warehouseName = warehouseDTO.getWarehouseName();
        this.warehouseShortName = warehouseDTO.getWarehouseShortName();
        this.isDefault = warehouseDTO.isDefault();
        this.version = warehouseDTO.getVersion();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseShortName() {
        return warehouseShortName;
    }

    public void setWarehouseShortName(String warehouseShortName) {
        this.warehouseShortName = warehouseShortName;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<SaleDocument> getSaleDocumentsCollection() {
        return saleDocumentsCollection;
    }

    public void setSaleDocumentsCollection(Collection<SaleDocument> saleDocumentsCollection) {
        this.saleDocumentsCollection = saleDocumentsCollection;
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
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.Warehouses[ warehouseId=" + id + " ]";
    }

    @XmlTransient
    public Collection<DocumentPosition> getDocumentsPositionsCollection() {
        return documentsPositionsCollection;
    }

    public void setDocumentsPositionsCollection(Collection<DocumentPosition> documentsPositionsCollection) {
        this.documentsPositionsCollection = documentsPositionsCollection;
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
