package pl.lodz.p.was04.department.core.dto.contractors;

import java.io.Serializable;

import pl.lodz.p.was04.department.core.domain.contractors.Contractor;
import pl.lodz.p.was04.department.core.domain.contractors.ContractorContact;

/**
 *
 * @author Janiu
 */
public class ContractorContactDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private String number;
    private Boolean isDefault;
    private Contractor contractor;

    public ContractorContactDTO() {
    }

    public ContractorContactDTO(Long id) {
        this.id = id;
    }

    public ContractorContactDTO(ContractorContact contractorContact) {        
        this.id = contractorContact.getId();
        this.name = contractorContact.getName();
        this.number = contractorContact.getNumber();
        this.isDefault = contractorContact.isDefault();
        this.contractor = contractorContact.getContractor();
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
    
}
