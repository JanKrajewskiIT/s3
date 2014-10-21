package pl.lodz.p.was04.department.core.dto.contractors;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.contractors.ContractorGroup;

/**
 *
 * @author Janiu
 */
public class ContractorGroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private boolean isActive = true;
    private Long version = 1L;

    public ContractorGroupDTO(ContractorGroup group) {
        this.id = group.getId();
        this.name = group.getName();
        this.isActive = group.isActive();
        this.version = group.getVersion();
    }
    
    public ContractorGroupDTO(ContractorGroupDTO group) {
        this.id = group.getId();
        this.name = group.getName();
        this.isActive = group.isActive();
        this.version = group.getVersion();
    }

    public ContractorGroupDTO() {
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

    public Boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
