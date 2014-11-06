package pl.lodz.p.project.core.jsf.contractor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.service.contractor.ContractorGroupService;

/**
 *
 * @author janiu
 */
@Named(value = "contractorGroupBean")
@Scope("request")
public class ContractorGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorGroupService contractorGroupService;
    
    private List<ContractorGroupDTO> contractorGroupList;
    
    public ContractorGroupBean() { }
    
    @PostConstruct
    public void init() {
        contractorGroupList = contractorGroupService.getAll();
    }

	public List<ContractorGroupDTO> getContractorGroupList() {
		return contractorGroupList;
	}

	public void setContractorGroupList(List<ContractorGroupDTO> contractorGroupList) {
		this.contractorGroupList = contractorGroupList;
	}
    
}
