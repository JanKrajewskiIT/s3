package pl.lodz.p.was04.department.core.jsf.contractors;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorGroupDTO;
import pl.lodz.p.was04.department.core.endpoint.contractors.ContractorsGroupsManagementEndpointLocal;

/**
 *
 * @author janiu
 */
@Named(value = "contractorsGroupsBean")
@Scope("view")
public class ContractorsGroupsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorsGroupsManagementEndpointLocal contractorsGroupsManagementEndpointLocal;
    
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
