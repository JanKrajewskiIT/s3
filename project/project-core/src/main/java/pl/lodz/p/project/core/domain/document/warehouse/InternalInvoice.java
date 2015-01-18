package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice {

	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.invoice", cascade = CascadeType.ALL)
	private List<InternalInvoiceGood> goodList;

	@XmlTransient
	public List<InternalInvoiceGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<InternalInvoiceGood> goodList) {
		this.goodList = goodList;
	}
}
