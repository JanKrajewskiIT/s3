package pl.lodz.p.was04.department.core.domain.documents;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Persistable;

import pl.lodz.p.was04.department.core.domain.User;
import pl.lodz.p.was04.department.core.domain.contractors.Contractor;
import pl.lodz.p.was04.department.core.dto.documents.WarehouseDocumentDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "warehouse_documents")
@XmlRootElement
public class WarehouseDocument implements Serializable, Persistable<WarehouseDocumentPK> {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WarehouseDocumentPK id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "type")
    private String type;
    @Column(name = "document_date")
    @Temporal(TemporalType.DATE)
    private Date documentDate;
    @Column(name = "warehouse_date")
    @Temporal(TemporalType.DATE)
    private Date warehouseDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "waybill_number")
    private String waybillNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "warehouse_result")
    private boolean warehouseResult;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active;
    @Version
    private long version;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouses;
    @JoinColumn(name = "issue_person", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User issuePerson;
    @JoinColumn(name = "transport_id", referencedColumnName = "transport_id")
    @ManyToOne(optional = false)
    private MeanOfTransport transportId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_place")
    private String documentPlace;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private Department departmentId;
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne
    private Contractor contractorId;
    @JoinColumn(name = "receive_person", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor receivePerson;

    public WarehouseDocument() {
    }

    public WarehouseDocument(WarehouseDocumentPK id) {
        this.id = id;
    }

    public WarehouseDocument(WarehouseDocumentPK id, String type, BigDecimal total, String waybillNumber, boolean warehouseResult, boolean active, long version) {
        this.id = id;
        this.type = type;
        this.total = total;
        this.waybillNumber = waybillNumber;
        this.warehouseResult = warehouseResult;
        this.active = active;
        this.version = version;
    }

    public WarehouseDocument(String symbol, Long warehouseId) {
        this.id = new WarehouseDocumentPK(symbol, warehouseId);
    }

    public WarehouseDocument(WarehouseDocumentDTO warehouseDocument) {
        this.id = new WarehouseDocumentPK(warehouseDocument.getSymbol(), warehouseDocument.getWarehouse().getId());
        this.contractorId = new Contractor(warehouseDocument.getContractor());
        this.departmentId = new Department(warehouseDocument.getDepartment());
        this.documentDate = warehouseDocument.getDocumentDate();
        this.documentPlace = warehouseDocument.getDocumentPlace();
        this.issuePerson = new User(warehouseDocument.getIssuePerson());
        this.receivePerson = new Contractor(warehouseDocument.getReceivePerson());
        this.total = warehouseDocument.getTotal();
        this.transportId = new MeanOfTransport(warehouseDocument.getTransport());
        this.type = warehouseDocument.getType();
        this.warehouseDate = warehouseDocument.getWarehouseDate();
        this.warehouseResult = warehouseDocument.isWarehouseResult();
        this.warehouses = new Warehouse(warehouseDocument.getWarehouse());
        this.waybillNumber = warehouseDocument.getWaybillNumber();
    }

    @Override
    public WarehouseDocumentPK getId() {
        return id;
    }

    public void setId(WarehouseDocumentPK id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public boolean getWarehouseResult() {
        return warehouseResult;
    }

    public void setWarehouseResult(boolean warehouseResult) {
        this.warehouseResult = warehouseResult;
    }

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

    public Warehouse getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Warehouse warehouses) {
        this.warehouses = warehouses;
    }

    public User getIssuePerson() {
        return issuePerson;
    }

    public void setIssuePerson(User issuePerson) {
        this.issuePerson = issuePerson;
    }

    public MeanOfTransport getTransportId() {
        return transportId;
    }

    public void setTransportId(MeanOfTransport transportId) {
        this.transportId = transportId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Contractor getContractorId() {
        return contractorId;
    }

    public void setContractorId(Contractor contractorId) {
        this.contractorId = contractorId;
    }

    public Contractor getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(Contractor receivePerson) {
        this.receivePerson = receivePerson;
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
        if (!(object instanceof WarehouseDocument)) {
            return false;
        }
        WarehouseDocument other = (WarehouseDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.WarehouseDocuments[ warehouseDocumentsPK=" + id + " ]";
    }

    /**
     * @return the documentPlace
     */
    public String getDocumentPlace() {
        return documentPlace;
    }

    /**
     * @param documentPlace the documentPlace to set
     */
    public void setDocumentPlace(String documentPlace) {
        this.documentPlace = documentPlace;
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
