package pl.lodz.p.project.core.dto.document.sale;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;

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
    private Boolean warehouseResult = true;
    private Boolean paid;
    private PaymentMethodDTO paymentMethod;
    private List<DocumentPositionDTO> goodsPositions;

    @NotNull(message = "Data sprzedaży nie może być pusta!")
    private Date saleDate;
    
    @NotNull(message = "Data płatności nie może być pusta!")
    private Date paymentDate;
    
    @NotNull(message = "Wartość Brutto po rabacie nie może być pusta!")
    private Double total = 0d;

    @NotNull(message = "Miejsce wystawienia nie może być puste!")
    private String documentPlace;
    
    @NotNull(message = "Pole Wystawił nie może być puste!")
    private ContractorDTO receivePerson;
    
    @NotNull(message = "Pole Nabywca nie może być puste!")
    private ContractorDTO contractor;

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

	public Boolean isWarehouseResult() {
		return warehouseResult;
	}

	public void setWarehouseResult(Boolean warehouseResult) {
		this.warehouseResult = warehouseResult;
	}

	public Boolean isPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public PaymentMethodDTO getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<DocumentPositionDTO> getGoodsPositions() {
		return goodsPositions;
	}

	public void setGoodsPositions(List<DocumentPositionDTO> goodsPositions) {
		this.goodsPositions = goodsPositions;
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

	public ContractorDTO getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(ContractorDTO receivePerson) {
		this.receivePerson = receivePerson;
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
   
}
