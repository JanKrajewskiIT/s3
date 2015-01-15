package pl.lodz.p.project.core.dto.good;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class GoodGroupDTO extends NamedDTO<Long> implements Comparable<GoodGroupDTO> {

	private static final long serialVersionUID = 1L;

    public GoodGroupDTO() { }
    
    public GoodGroupDTO(GoodGroupDTO goodGroup) {
    	setName(goodGroup.getName());
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(GoodGroupDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
    
}
