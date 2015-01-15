package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice {

	private static final long serialVersionUID = 1L;

}
