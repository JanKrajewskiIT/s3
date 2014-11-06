package pl.lodz.p.project.core.jsf.contractor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.contractor.ContractorContactDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.service.contractor.ContractorContactService;

/**
 *
 * @author janiu
 */
@Named(value = "contractorContactBean")
@Scope("request")
public class ContractorContact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorContactService contractorContactService;
    
    private List<ContractorContactDTO> contractorContactList;
    
    public ContractorContact() { }
    
    @PostConstruct
    public void init() {
        contractorContactList = new ArrayList<>();
    }
    
    public List<ContractorContactDTO> initContractorContract(ContractorDTO contractor) {
        contractorContactList = contractorContactService.getAll();
        return contractorContactList;
    }

	public List<ContractorContactDTO> getContractorContactList() {
		return contractorContactList;
	}

	public void setContractorContactList(List<ContractorContactDTO> contractorContactList) {
		this.contractorContactList = contractorContactList;
	}

}
