package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import pl.lodz.p.was04.department.core.domain.documents.SaleDocument;
import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;

/**
 *
 * @author janiu
 */
public class SaleDocumentDTO implements Serializable, Comparable<SaleDocumentDTO> {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Symbol nie może być pusty!")
    private String symbol;
    private String type;
    @NotNull(message = "Data wystawienia dokumentu nie może być pusta!")
    private Date documentDate;
    @NotNull(message = "Data sprzedaży nie może być pusta!")
    private Date saleDate;
    @NotNull(message = "Data płatności nie może być pusta!")
    private Date paymentDate;
    @NotNull(message = "Wartość Brutto po rabacie nie może być pusta!")
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal paidTotal = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;
    private String orderSymbol;
    private boolean warehouseResult = true;
    private boolean paid;
    private WarehouseDTO warehouse;
    @NotNull(message = "Pole Odebrał nie może być puste!")
    private UserDTO issuePerson;
    private PaymentMethodDTO methodOfPayment;
    @NotNull(message = "Miejsce wystawienia nie może być puste!")
    private String documentPlace;
    @NotNull(message = "Pole Wystawił nie może być puste!")
    private ContractorDTO receivePerson;
    @NotNull(message = "Pole Nabywca nie może być puste!")
    private ContractorDTO contractor;
    private boolean active = true;
    private Long version = 1L;
    
    private List<DocumentPositionDTO> goodsPositions;

    public SaleDocumentDTO() {
        methodOfPayment = new PaymentMethodDTO();
    }

    public SaleDocumentDTO(SaleDocument saleDocument) {
        this.symbol = saleDocument.getId().getSymbol();
        this.type = saleDocument.getType();
        this.documentDate = saleDocument.getDocumentDate();
        this.saleDate = saleDocument.getSaleDate();
        this.paymentDate = saleDocument.getPaymentDate();
        this.total = saleDocument.getTotal();
        this.paidTotal = saleDocument.getPaid();
        this.discount = saleDocument.getDiscount();
        this.orderSymbol = saleDocument.getOrderSymbol();
        this.warehouseResult = saleDocument.isWarehouseResult();
        this.paid = saleDocument.isPaid();
        this.warehouse = new WarehouseDTO(saleDocument.getWarehouse());
        this.issuePerson = new UserDTO(saleDocument.getIssuePerson());
        this.version = saleDocument.getVersion();
        this.methodOfPayment = new PaymentMethodDTO(saleDocument.getMethodOfPaymentId());
        this.documentPlace = saleDocument.getDocumentPlace();
        this.receivePerson = new ContractorDTO(saleDocument.getReceivePerson());
        this.contractor = new ContractorDTO(saleDocument.getContractorId());
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

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouses(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public UserDTO getIssuePerson() {
        return issuePerson;
    }

    public void setIssuePerson(UserDTO issuePerson) {
        this.issuePerson = issuePerson;
    }

    public PaymentMethodDTO getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(PaymentMethodDTO methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
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
        setReceivePerson(contractor);
        discount = contractor.getDiscount();
        this.contractor = contractor;
    }

    @Override
    public int compareTo(SaleDocumentDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the documentPlace
     */
    public String getDocumentPlace() {
        return documentPlace;
    }

    /**
     * @param documentPlace the documentPlace to set
     */
    public void setDocumentPlace(String documentPlace) {
        this.documentPlace = documentPlace;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the paid
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public List<DocumentPositionDTO> getGoodsPositions() {
        return goodsPositions;
    }

    public void setGoodsPositions(List<DocumentPositionDTO> goodsPositions) {
        this.goodsPositions = goodsPositions;
    }
    
}
