package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.items.TransportMean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "external_invoices")
public class ExternalInvoice extends WarehouseInvoice<ExternalInvoiceGood> {

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

	@NotNull
	@Column(name = "delivery_date")
	private Date deliveryDate;

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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}

