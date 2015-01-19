package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.items.TransportMean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "external_invoices")
public class ExternalInvoice extends WarehouseInvoice { 

	private static final long serialVersionUID = 1L;

    @JoinColumn(name = "contractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contractor contractor;

    @JoinColumn(name = "transport_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransportMean transportMean;
    
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "order_symbol")
    private String orderSymbol;
/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.invoice", cascade = CascadeType.ALL)
	private List<ExternalInvoiceGood> goodList;
*/
	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public TransportMean getTransportMean() {
		return transportMean;
	}

	public void setTransportMean(TransportMean transportMean) {
		this.transportMean = transportMean;
	}

	public String getOrderSymbol() {
		return orderSymbol;
	}

	public void setOrderSymbol(String orderSymbol) {
		this.orderSymbol = orderSymbol;
	}
/*
	@XmlTransient
	public List<ExternalInvoiceGood> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<ExternalInvoiceGood> goodList) {
		this.goodList = goodList;
	}
*/
}

