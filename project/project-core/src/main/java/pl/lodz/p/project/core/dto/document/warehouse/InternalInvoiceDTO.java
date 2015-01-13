package pl.lodz.p.project.core.dto.document.warehouse;

import pl.lodz.p.project.core.dto.account.UserDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class InternalInvoiceDTO implements Serializable, Comparable<InternalInvoiceDTO>  {

	private static final long serialVersionUID = 7633882275429075975L;

	private Long id;
	private Long version = 1L;
	private String symbol;
	private String type;
	private Date documentDate;
	private Double total;	
	private UserDTO issuePerson;
	private String receivePerson;
	private String deliverPerson;
	private String annotation;
	private List<InternalInvoiceGoodDTO> goodList;
	
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

	public UserDTO getIssuePerson() {
		return issuePerson;
	}

	public void setIssuePerson(UserDTO issuePerson) {
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

	public List<InternalInvoiceGoodDTO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<InternalInvoiceGoodDTO> goodList) {
		this.goodList = goodList;
	}

	@Override
	public int compareTo(InternalInvoiceDTO o) {
		return 0;
	}	
	
}
