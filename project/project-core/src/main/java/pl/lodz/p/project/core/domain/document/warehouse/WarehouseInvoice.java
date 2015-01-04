package pl.lodz.p.project.core.domain.document.warehouse;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pl.lodz.p.project.core.domain.BaseEntity;

/**
 * 
 * @author Jan Krajewski
 *
 */
@MappedSuperclass
public abstract class WarehouseInvoice extends BaseEntity<Long> {

	private static final long serialVersionUID = 1469119918661275184L;
    	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "symbol")
	private String symbol;

    @Basic(optional = false)
    @NotNull
    @Column(name = "document_date")
    @Temporal(TemporalType.DATE)
	private Date documentDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
	private Double total;	
    
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "issue_person")
	private String issuePerson;
	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "receive_person")
	private String receivePerson;
	
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "deliver_person")
	private String deliverPerson;	
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	
}
