package pl.lodz.p.project.core.dto.document.warehouse;

import com.google.common.collect.ComparisonChain;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class InternalInvoiceDTO extends WarehouseInvoiceDTO<InternalInvoiceGoodDTO> implements Comparable<InternalInvoiceDTO> {

	private static final long serialVersionUID = 1L;

	public InternalInvoiceDTO() {
		setType("RW");
	}

	@Override
	public int compareTo(InternalInvoiceDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
