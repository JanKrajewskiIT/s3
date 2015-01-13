package pl.lodz.p.project.core.dto.document.warehouse;

import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public class ExternalInvoiceDTO extends DocumentDTO<Long> implements Comparable<ExternalInvoiceDTO> {

    private static final long serialVersionUID = 5643355468874031693L;

    private Long id;
    private Double total;
    private String receivePerson;
    private String deliverPerson;
    private String annotation;
    private List<ExternalInvoiceGoodDTO> goodList;

    private ContractorDTO contractor;
    private TransportMeanDTO transportMean;
    private String orderSymbol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ExternalInvoiceGoodDTO> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<ExternalInvoiceGoodDTO> goodList) {
        this.goodList = goodList;
    }

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

    public String getOrderSymbol() {
        return orderSymbol;
    }

    public void setOrderSymbol(String orderSymbol) {
        this.orderSymbol = orderSymbol;
    }

    @Override
    public int compareTo(ExternalInvoiceDTO o) {
        return 0;
    }

}
