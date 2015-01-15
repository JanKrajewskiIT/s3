package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public class InvoiceGood<T extends Serializable> extends BaseEntity<T> {

    private static final long serialVersionUID = 4953126124258975050L;

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
