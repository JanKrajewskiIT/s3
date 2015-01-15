package pl.lodz.p.project.core.dto.document.items;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class TransportMeanDTO extends NamedDTO<Long> implements Comparable<TransportMeanDTO>  {

	private static final long serialVersionUID = 1L;

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(TransportMeanDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
