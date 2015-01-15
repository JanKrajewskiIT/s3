package pl.lodz.p.project.core.dto.contractor;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class ContractorContactDTO extends NamedDTO<Long> implements Comparable<ContractorContactDTO> {

	private static final long serialVersionUID = 1L;

    private String number;
    private Boolean isDefault;
    private ContractorDTO contractor;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public ContractorDTO getContractor() {
        return contractor;
    }
    
    public void setContractor(ContractorDTO contractor) {
        this.contractor = contractor;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(ContractorContactDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}
    
}
