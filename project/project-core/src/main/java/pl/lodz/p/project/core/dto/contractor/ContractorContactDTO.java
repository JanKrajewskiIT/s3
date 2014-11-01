package pl.lodz.p.project.core.dto.contractor;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.domain.contractor.Contractor;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu
 */
public class ContractorContactDTO implements Serializable, Comparable<ContractorContactDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private String number;
    private Boolean isDefault;
    private Contractor contractor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Contractor getContractor() {
        return contractor;
    }
    
    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(ContractorContactDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}
    
}
