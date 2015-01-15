package pl.lodz.p.project.core.dto.document.items;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class PaymentMethodDTO extends NamedDTO<Long> implements Comparable<PaymentMethodDTO> {
    
	private static final long serialVersionUID = 1L;

	private Integer maturity;

	public Integer getMaturity() {
		return maturity;
	}

	public void setMaturity(Integer maturity) {
		this.maturity = maturity;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(PaymentMethodDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
    
}
