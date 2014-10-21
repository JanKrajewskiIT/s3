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
import pl.lodz.p.was04.department.core.dto.documents.SaleDocumentDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "sale_documents")
@XmlRootElement
public class SaleDocument implements Serializable, Persistable<SaleDocumentPK> {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SaleDocumentPK id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_date")
    @Temporal(TemporalType.DATE)
    private Date documentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paid")
    private BigDecimal paid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "order_symbol")
    private String orderSymbol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "warehouse_result")
    private boolean warehouseResult = true;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_paid")
    private boolean isPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active;
    @Version
    private long version;
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouse;
    @JoinColumn(name = "issue_person", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User issuePerson;
    @JoinColumn(name = "method_of_payment_id", referencedColumnName = "mop_id")
    @ManyToOne(optional = false)
    private PaymentMethod methodOfPaymentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_place")
    private String documentPlace;
    @JoinColumn(name = "receive_person", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor receivePerson;
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor contractorId;

    public SaleDocument() {
    }

    public SaleDocument(SaleDocumentPK id) {
        this.id = id;
    }

    public SaleDocument(SaleDocumentPK id, String type, Date documentDate, Date saleDate, Date paymentDate, BigDecimal total, BigDecimal paid, BigDecimal discount, String orderSymbol, boolean warehouseResult, boolean isPaid, boolean active, long version) {
        this.id = id;
        this.type = type;
        this.documentDate = documentDate;
        this.saleDate = saleDate;
        this.paymentDate = paymentDate;
        this.total = total;
        this.paid = paid;
        this.discount = discount;
        this.orderSymbol = orderSymbol;
        this.warehouseResult = warehouseResult;
        this.isPaid = isPaid;
        this.active = active;
        this.version = version;
    }

    public SaleDocument(String symbol, Long warehouseId) {
        this.id = new SaleDocumentPK(symbol, warehouseId);
    }

    public SaleDocument(SaleDocumentDTO saleDocument) {
        this.active = saleDocument.isActive();
        this.contractorId = new Contractor(saleDocument.getContractor());
        this.discount = saleDocument.getDiscount();
        this.documentDate = saleDocument.getDocumentDate();
        this.documentPlace = saleDocument.getDocumentPlace();
        this.isPaid = saleDocument.isPaid();
        this.issuePerson = new User(saleDocument.getIssuePerson());
        this.methodOfPaymentId = new PaymentMethod(saleDocument.getMethodOfPayment());
        this.orderSymbol = saleDocument.getOrderSymbol();
        this.paid = saleDocument.getPaidTotal();
        this.paymentDate = saleDocument.getPaymentDate();
        this.receivePerson = new Contractor(saleDocument.getReceivePerson());
        this.saleDate = saleDocument.getSaleDate();
        this.total = saleDocument.getTotal();
        this.type = saleDocument.getType();
        this.version = saleDocument.getVersion();
        this.warehouseResult = saleDocument.isWarehouseResult();
        this.warehouse = new Warehouse(saleDocument.getWarehouse());
        this.id = new SaleDocumentPK(saleDocument.getSymbol(),saleDocument.getWarehouse().getId());
    }

    @Override
    public SaleDocumentPK getId() {
        return id;
    }

    public void setId(SaleDocumentPK id) {
        this.id = id;
    }

    public void setSaleDocumentsPK(SaleDocumentPK id) {
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getOrderSymbol() {
        return orderSymbol;
    }

    public void setOrderSymbol(String orderSymbol) {
        this.orderSymbol = orderSymbol;
    }

    public boolean isWarehouseResult() {
        return warehouseResult;
    }

    public void setWarehouseResult(boolean warehouseResult) {
        this.warehouseResult = warehouseResult;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public User getIssuePerson() {
        return issuePerson;
    }

    public void setIssuePerson(User issuePerson) {
        this.issuePerson = issuePerson;
    }

    public PaymentMethod getMethodOfPaymentId() {
        return methodOfPaymentId;
    }

    public void setMethodOfPaymentId(PaymentMethod methodOfPaymentId) {
        this.methodOfPaymentId = methodOfPaymentId;
    }

    public String getDocumentPlace() {
        return documentPlace;
    }

    public void setDocumentPlace(String documentPlace) {
        this.documentPlace = documentPlace;
    }

    public Contractor getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(Contractor receivePerson) {
        this.receivePerson = receivePerson;
    }

    public Contractor getContractorId() {
        return contractorId;
    }

    public void setContractorId(Contractor contractorId) {
        this.contractorId = contractorId;
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
        if (!(object instanceof SaleDocument)) {
            return false;
        }
        SaleDocument other = (SaleDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.SaleDocuments[ saleDocumentsPK=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
}
