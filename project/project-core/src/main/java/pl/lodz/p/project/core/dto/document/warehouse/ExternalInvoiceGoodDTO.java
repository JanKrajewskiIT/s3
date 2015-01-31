package pl.lodz.p.project.core.dto.document.warehouse;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.document.base.InvoiceGoodDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class ExternalInvoiceGoodDTO extends InvoiceGoodDTO<ExternalInvoiceDTO> implements Comparable<ExternalInvoiceGoodDTO> {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public int compareTo(ExternalInvoiceGoodDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
}
