package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private List<InternalInvoiceGood> goodList;

	public List<InternalInvoiceGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<InternalInvoiceGood> goodList) {
		this.goodList = goodList;
	}
}
