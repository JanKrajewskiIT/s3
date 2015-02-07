package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.document.base.Document;
import pl.lodz.p.project.core.domain.document.base.InvoiceGood;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public abstract class WarehouseInvoice<T extends InvoiceGood> extends Document<Long> {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @NotNull
    @Column(name = "total")
	private Double total = 0.00;

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "receive_person")
	private String receivePerson;
	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "deliver_person")
	private String deliverPerson;

	@Column(name = "annotation")
	private String annotation;

	@OneToMany(mappedBy = "id.invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<T> invoiceGoodList;

	public Set<T> getInvoiceGoodList() {
		return invoiceGoodList;
	}

	public void setInvoiceGoodList(Set<T> invoiceGoodList) {
		this.invoiceGoodList = invoiceGoodList;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
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
