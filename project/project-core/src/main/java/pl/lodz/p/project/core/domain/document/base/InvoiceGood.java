package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public abstract class InvoiceGood<T extends Document> extends BaseEntity<InvoiceGoodKey<T>> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private Double quantity;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
