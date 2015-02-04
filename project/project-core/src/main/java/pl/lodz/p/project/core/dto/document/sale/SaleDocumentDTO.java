package pl.lodz.p.project.core.dto.document.sale;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Janiu
 */
public class SaleDocumentDTO extends DocumentDTO<Long> implements Comparable<SaleDocumentDTO> {

	private static final long serialVersionUID = 1L;

    private Double paidTotal = 0d;
    private Double discount = 0d;
    private String orderSymbol;
	private boolean warehouseResult = true;
	private boolean paid;
	private String receivePerson;
	private String deliverPerson;
	private PaymentMethodDTO paymentMethod;
	private List<DocumentPositionDTO> goodList;
	private String annotation;

    @NotNull(message = "Data sprzedaży nie może być pusta!")
    private Date saleDate;
    
    @NotNull(message = "Data płatności nie może być pusta!")
    private Date paymentDate;
    
    @NotNull(message = "Wartość Brutto po rabacie nie może być pusta!")
    private Double total = 0d;

    @NotNull(message = "Miejsce wystawienia nie może być puste!")
    private String documentPlace;

    @NotNull(message = "Pole Nabywca nie może być puste!")
    private ContractorDTO contractor;

	private TransportMeanDTO transportMean;

	public Double getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(Double paidTotal) {
		this.paidTotal = paidTotal;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getOrderSymbol() {
		return orderSymbol;
	}

	public void setOrderSymbol(String orderSymbol) {
		this.orderSymbol = orderSymbol;
	}

	public boolean isWarehouseResult() {
		return warehouseResult;
	}

	public void setWarehouseResult(boolean warehouseResult) {
		this.warehouseResult = warehouseResult;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public PaymentMethodDTO getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<DocumentPositionDTO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<DocumentPositionDTO> goodList) {
		this.goodList = goodList;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDocumentPlace() {
		return documentPlace;
	}

	public void setDocumentPlace(String documentPlace) {
		this.documentPlace = documentPlace;
	}

	public ContractorDTO getContractor() {
		return contractor;
	}

	public void setContractor(ContractorDTO contractor) {
		this.contractor = contractor;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(SaleDocumentDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}

	public String getReceivePerson() {
		return receivePerson;
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
	public TransportMeanDTO getTransportMean() {
		return transportMean;
	}

	public void setTransportMean(TransportMeanDTO transportMean) {
		this.transportMean = transportMean;
	}
}
