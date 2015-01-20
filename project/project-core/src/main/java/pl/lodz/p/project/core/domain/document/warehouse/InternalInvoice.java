package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;
import java.util.Set;

/**
 * @author Jan Krajewski
 */
//@Entity
//@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice {

	private static final long serialVersionUID = 1L;

	//@JoinTable(name = "internal_invoices_goods")
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<InternalInvoiceGood> goodList;

	@XmlTransient
	public Set<InternalInvoiceGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(Set<InternalInvoiceGood> goodList) {
		this.goodList = goodList;
	}

	/*
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id.invoice", insertable = false, updatable = false)
	private List<InternalInvoiceGood> goodList;

*/
}
