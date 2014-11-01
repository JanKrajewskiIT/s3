package pl.lodz.p.project.core.domain.document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.domain.Activable;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.contractor.Contractor;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "sale_documents")
@XmlRootElement
public class SaleDocument implements Serializable, Activable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_document_id")
    private Long id;
	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "symbol")
    private String symbol;
	
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
    private BigDecimal paidTotal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private BigDecimal discount;
    
    @Column(name = "order_symbol")
    private String orderSymbol;

    @Basic(optional = false)
    @NotNull
    @Column(name = "document_place")
    private String documentPlace;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "warehouse_result")
    private boolean warehouseResult = true;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_paid")
    private boolean paid;
        
    @JoinColumn(name = "receive_person", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor receivePerson;
    
    @JoinColumn(name = "issue_person", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User issuePerson;
    
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id")
    @ManyToOne(optional = false)
    private PaymentMethod paymentMethod;
    
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor contractor;

    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active;
    
    @Version
    private long version;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public BigDecimal getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(BigDecimal paidTotal) {
		this.paidTotal = paidTotal;
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

	public String getDocumentPlace() {
		return documentPlace;
	}

	public void setDocumentPlace(String documentPlace) {
		this.documentPlace = documentPlace;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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

	public Contractor getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(Contractor receivePerson) {
		this.receivePerson = receivePerson;
	}

	public User getIssuePerson() {
		return issuePerson;
	}

	public void setIssuePerson(User issuePerson) {
		this.issuePerson = issuePerson;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public boolean isWarehouseResult() {
		return warehouseResult;
	}

	public void setWarehouseResult(boolean warehouseResult) {
		this.warehouseResult = warehouseResult;
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
