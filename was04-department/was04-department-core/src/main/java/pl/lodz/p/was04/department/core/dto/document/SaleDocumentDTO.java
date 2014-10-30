package pl.lodz.p.was04.department.core.dto.document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.dto.account.UserDTO;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorDTO;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu
 */
public class SaleDocumentDTO implements Serializable, Comparable<SaleDocumentDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String type;
    private BigDecimal paidTotal = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;
    private String orderSymbol;
    private boolean warehouseResult = true;
    private boolean paid;
    private PaymentMethodDTO methodOfPayment;
    private List<DocumentPositionDTO> goodsPositions;
	
	@NotNull(message = "Symbol nie może być pusty!")
    private String symbol;	
    
    @NotNull(message = "Data wystawienia dokumentu nie może być pusta!")
    private Date documentDate;
    
    @NotNull(message = "Data sprzedaży nie może być pusta!")
    private Date saleDate;
    
    @NotNull(message = "Data płatności nie może być pusta!")
    private Date paymentDate;
    
    @NotNull(message = "Wartość Brutto po rabacie nie może być pusta!")
    private BigDecimal total = BigDecimal.ZERO;
    
    @NotNull(message = "Pole Odebrał nie może być puste!")
    private UserDTO issuePerson;
        
    @NotNull(message = "Miejsce wystawienia nie może być puste!")
    private String documentPlace;
    
    @NotNull(message = "Pole Wystawił nie może być puste!")
    private ContractorDTO receivePerson;
    
    @NotNull(message = "Pole Nabywca nie może być puste!")
    private ContractorDTO contractor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(BigDecimal paidTotal) {
		this.paidTotal = paidTotal;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
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

	public PaymentMethodDTO getMethodOfPayment() {
		return methodOfPayment;
	}

	public void setMethodOfPayment(PaymentMethodDTO methodOfPayment) {
		this.methodOfPayment = methodOfPayment;
	}

	public List<DocumentPositionDTO> getGoodsPositions() {
		return goodsPositions;
	}

	public void setGoodsPositions(List<DocumentPositionDTO> goodsPositions) {
		this.goodsPositions = goodsPositions;
	}

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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public UserDTO getIssuePerson() {
		return issuePerson;
	}

	public void setIssuePerson(UserDTO issuePerson) {
		this.issuePerson = issuePerson;
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
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}
   
}
