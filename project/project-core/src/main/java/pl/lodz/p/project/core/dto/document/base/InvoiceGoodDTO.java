package pl.lodz.p.project.core.dto.document.base;

import pl.lodz.p.project.core.dto.base.BaseDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;

/**
 * @author Jan Krajewski
 */
public class InvoiceGoodDTO<T extends DocumentDTO> extends BaseDTO<Long> {

    private static final long serialVersionUID = 1L;

    private GoodDTO good;
    private T invoice;
    private Double quantity;

    public GoodDTO getGood() {
        return good;
    }

    public void setGood(GoodDTO good) {
        this.good = good;
    }

    public T getInvoice() {
        return invoice;
    }

    public void setInvoice(T invoice) {
        this.invoice = invoice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
