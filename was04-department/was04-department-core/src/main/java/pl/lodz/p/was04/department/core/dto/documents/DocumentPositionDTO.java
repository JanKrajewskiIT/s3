package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.dto.goods.GoodDTO;
import pl.lodz.p.was04.department.core.dto.goods.TaxDTO;

/**
 *
 * @author janiu
 */
public class DocumentPositionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String symbol;
    private double quantity;
    private BigDecimal priceNet = BigDecimal.ZERO;
    private BigDecimal priceGross = BigDecimal.ZERO;
    private BigDecimal valueNet = BigDecimal.ZERO;
    private BigDecimal valueGross = BigDecimal.ZERO;
    private WarehouseDTO warehouse;
    private TaxDTO tax;
    private GoodDTO good;

    public DocumentPositionDTO(DocumentPosition documentPosition) {
        this.symbol = documentPosition.getId().getDocumentSymbol();
        this.quantity = documentPosition.getQuantity();
        this.priceNet = documentPosition.getPriceNet();
        this.warehouse = new WarehouseDTO(documentPosition.getWarehouses());
        this.tax = new TaxDTO(documentPosition.getTax());
        this.good = new GoodDTO(documentPosition.getGood());
    }

    public DocumentPositionDTO() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
        this.valueNet = priceNet.multiply(BigDecimal.valueOf(quantity));
        this.valueGross = priceGross.multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getPriceNet() {
        return priceNet;
    }

    public BigDecimal getPriceGross() {
        return priceGross;
    }

    public void setPriceGross(BigDecimal priceGross) {
        this.priceGross = priceGross;
        this.valueGross = priceGross.multiply(BigDecimal.valueOf(quantity));
    }
    
    public void setPriceNet(BigDecimal priceNet) {
        this.priceNet = priceNet;
        this.valueNet = priceNet.multiply(BigDecimal.valueOf(quantity));
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public TaxDTO getTax() {
        return tax;
    }

    public void setTax(TaxDTO tax) {
        this.tax = tax;
    }

    public GoodDTO getGood() {
        return good;
    }

    public void setGood(GoodDTO good) {
        this.good = good;
    }

    public BigDecimal getValueNet() {
        return valueNet;
    }

    public BigDecimal getValueGross() {
        return valueGross;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
