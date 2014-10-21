package pl.lodz.p.was04.department.core.domain.documents;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.documents.MeanOfTransportDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "means_of_transport")
@XmlRootElement
public class MeanOfTransport implements Serializable, Activable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name = "transport_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "transport_name")
    private String transportName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportId")
    private Collection<WarehouseDocument> warehouseDocumentsCollection;

    public MeanOfTransport() {
    }

    public MeanOfTransport(Long id) {
        this.id = id;
    }

    public MeanOfTransport(MeanOfTransportDTO meanOfTransport) {
        this.id = meanOfTransport.getId();
        this.transportName = meanOfTransport.getTransportName();
    }

    public MeanOfTransport(Long id, String transportName, boolean active, long version) {
        this.id = id;
        this.transportName = transportName;
        this.active = active;
        this.version = version;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
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
        if (!(object instanceof MeanOfTransport)) {
            return false;
        }
        MeanOfTransport other = (MeanOfTransport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.MeansOfTransport[ transportId=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
