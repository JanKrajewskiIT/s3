package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.document.base.Document;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public abstract class WarehouseInvoice extends Document<Long> {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @NotNull
    @Column(name = "total")
	private Double total;	

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

	@Basic(optional = false)
	@Column(name = "annotation")
	private String annotation;

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
