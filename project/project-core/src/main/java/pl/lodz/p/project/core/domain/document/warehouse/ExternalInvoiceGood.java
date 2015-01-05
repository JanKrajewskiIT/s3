package pl.lodz.p.project.core.domain.document.warehouse;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import pl.lodz.p.project.core.domain.BaseEntity;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Entity
@Table(name = "external_invoice_goods")
public class ExternalInvoiceGood extends BaseEntity<InvoiceGoodKey<ExternalInvoice>> {

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
