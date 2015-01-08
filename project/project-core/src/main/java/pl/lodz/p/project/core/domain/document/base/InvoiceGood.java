package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public class InvoiceGood<T extends Serializable> extends BaseEntity<T>  {

    private static final long serialVersionUID = 4953126124258975050L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private BigDecimal quantity;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}
