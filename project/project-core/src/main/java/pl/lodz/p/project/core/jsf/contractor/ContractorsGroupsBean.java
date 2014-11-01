package pl.lodz.p.project.core.jsf.contractor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.service.contractor.ContractorsGroupsService;

/**
 *
 * @author janiu
 */
@Named(value = "contractorsGroupsBean")
@Scope("request")
public class ContractorsGroupsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorsGroupsService contractorsGroupsManagementEndpointLocal;
    
    private List<ContractorGroupDTO> contractorsGroupsList;
    
    public ContractorsGroupsBean() {
    }
    
    @PostConstruct
    public void init() {
        contractorsGroupsList = contractorsGroupsManagementEndpointLocal.getContractorsGroups();
    }

    public List<ContractorGroupDTO> getContractorsGroupsList() {
        return contractorsGroupsList;
    }

    public void setContractorsGroupsList(List<ContractorGroupDTO> contractorsGroupsList) {
        this.contractorsGroupsList = contractorsGroupsList;
    }
    
}
