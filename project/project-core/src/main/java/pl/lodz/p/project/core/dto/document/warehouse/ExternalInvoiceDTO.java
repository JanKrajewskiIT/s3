package pl.lodz.p.project.core.dto.document.warehouse;

import com.google.common.collect.ComparisonChain;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;

import java.util.Date;

/**
 * @author Jan Krajewski
 */
public class ExternalInvoiceDTO extends WarehouseInvoiceDTO<ExternalInvoiceGoodDTO> implements Comparable<ExternalInvoiceDTO> {

    private static final long serialVersionUID = 1L;

    private ContractorDTO contractor;
    private TransportMeanDTO transportMean;
    private String orderSymbol;
    private Date deliveryDate;

    public ContractorDTO getContractor() {
        return contractor;
    }

    public void setContractor(ContractorDTO contractor) {
        this.contractor = contractor;
    }

    public TransportMeanDTO getTransportMean() {
        return transportMean;
    }

    public void setTransportMean(TransportMeanDTO transportMean) {
        this.transportMean = transportMean;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderSymbol() {
        return orderSymbol;
    }

    public void setOrderSymbol(String orderSymbol) {
        this.orderSymbol = orderSymbol;
    }

    @Override
    public int compareTo(ExternalInvoiceDTO o) {
        return ComparisonChain.start().compare(this.getId(), o.getId()).result();
    }
}
