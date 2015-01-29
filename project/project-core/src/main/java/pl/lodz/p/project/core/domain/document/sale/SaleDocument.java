package pl.lodz.p.project.core.domain.document.sale;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.base.Document;
import pl.lodz.p.project.core.domain.document.items.PaymentMethod;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "sale_documents")
public class SaleDocument extends Document<Long> {

    private static final long serialVersionUID = 1L;

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
	@Column(name = "deliver_person")
	private String deliverPerson;

	@Basic(optional = false)
	@Column(name = "reveive_person")
	private String receivePerson;

	@Basic(optional = true)
	@Column(name = "annotation")
	private String annotation;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private Double total;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "paid")
    private Double paidTotal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private Double discount;
    
    @Column(name = "order_symbol")
    private String orderSymbol;

    @Basic(optional = false)
    @NotNull
    @Column(name = "document_place")
    private String documentPlace;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "warehouse_result")
    private Boolean warehouseResult = true;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_paid")
    private Boolean paid;

    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PaymentMethod paymentMethod;
    
    @JoinColumn(name = "contractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contractor contractor;

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(Double paidTotal) {
		this.paidTotal = paidTotal;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
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

	public Boolean isPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public String getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
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

	public Boolean isWarehouseResult() {
		return warehouseResult;
	}

	public void setWarehouseResult(Boolean warehouseResult) {
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

	public String getDeliverPerson() {
		return deliverPerson;
	}

	public void setDeliverPerson(String deliverPerson) {
		this.deliverPerson = deliverPerson;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
}
