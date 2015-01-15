package pl.lodz.p.project.core.dto.contractor;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class ContractorGroupDTO extends NamedDTO<Long> implements Comparable<ContractorGroupDTO> {

	private static final long serialVersionUID = 1L;

    public ContractorGroupDTO() { }
    
    public ContractorGroupDTO(ContractorGroupDTO contractorGroupDTO) {
    	setName(contractorGroupDTO.getName());
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(ContractorGroupDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
    
}
