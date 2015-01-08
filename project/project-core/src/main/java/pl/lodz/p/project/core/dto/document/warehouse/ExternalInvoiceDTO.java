package pl.lodz.p.project.core.dto.document.warehouse;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.TransportMeanDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class ExternalInvoiceDTO implements Serializable, Comparable<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 5643355468874031693L;

	private Long id;
	private Long version = 1L;
	private String symbol;
	private String type;
	private Date documentDate;
	private Double total;	
	private String issuePerson;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getIssuePerson() {
		return issuePerson;
	}

	public void setIssuePerson(String issuePerson) {
		this.issuePerson = issuePerson;
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
