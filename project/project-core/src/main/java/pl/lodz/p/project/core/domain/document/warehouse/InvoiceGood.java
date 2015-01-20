package pl.lodz.p.project.core.domain.document.warehouse;

import pl.lodz.p.project.core.domain.base.BaseEntity;
import pl.lodz.p.project.core.domain.document.base.Document;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public class InvoiceGood<T extends Document> extends BaseEntity<InvoiceGoodKey<T>> {

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
