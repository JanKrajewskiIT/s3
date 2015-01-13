package pl.lodz.p.project.core.dto.document.warehouse;

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class InternalInvoiceDTO extends DocumentDTO<Long> implements Comparable<InternalInvoiceDTO>  {

	private static final long serialVersionUID = 7633882275429075975L;

	private Double total;
	private String receivePerson;
	private String deliverPerson;
	private String annotation;
	private List<InternalInvoiceGoodDTO> goodList;

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
