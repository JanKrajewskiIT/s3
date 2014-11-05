package pl.lodz.p.project.core.dto.contractor;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu
 */
public class ContractorGroupDTO implements Serializable, Comparable<ContractorGroupDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;

    public ContractorGroupDTO() { }
    
    public ContractorGroupDTO(ContractorGroupDTO contractorGroupDTO) {
    	this.name = contractorGroupDTO.getName();
	}

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

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(ContractorGroupDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}
    
}
