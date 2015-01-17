package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.base.BaseEntity;
import pl.lodz.p.project.core.domain.good.Good;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public abstract class InvoiceGood<T extends Serializable, ID extends Serializable> extends BaseEntity<ID> {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private T invoice;

    @JoinColumn(name = "good_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Good good;

    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private Double quantity;

    public T getInvoice() {
        return invoice;
    }

    public void setInvoice(T invoice) {
        this.invoice = invoice;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
