package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.TransportMean;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Entity
@Table(name = "external_invoices")
public class ExternalInvoice extends WarehouseInvoice { 

	private static final long serialVersionUID = 4420769465498341864L;
    
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor contractor;

    @JoinColumn(name = "transport_id", referencedColumnName = "transport_id")
    @ManyToOne(optional = false)
    private TransportMean transportMean;
    
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "order_symbol")
    private String orderSymbol;

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
    
}

