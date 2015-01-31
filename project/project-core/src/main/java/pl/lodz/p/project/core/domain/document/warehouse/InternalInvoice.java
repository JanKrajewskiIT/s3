package pl.lodz.p.project.core.domain.document.warehouse;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Jan Krajewski
 */
@Entity
@Table(name = "internal_invoices")
public class InternalInvoice extends WarehouseInvoice<InternalInvoiceGood> {

	private static final long serialVersionUID = 1L;

}
