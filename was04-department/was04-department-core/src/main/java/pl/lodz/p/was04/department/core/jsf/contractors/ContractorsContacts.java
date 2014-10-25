package pl.lodz.p.was04.department.core.jsf.contractors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorContactDTO;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;
import pl.lodz.p.was04.department.core.endpoint.contractors.ContractorsContactsManagementEndpointLocal;

/**
 *
 * @author janiu
 */
@Named(value = "contractorsContactsBean")
@Scope("request")
public class ContractorsContacts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorsContactsManagementEndpointLocal contractorsContactsManagementEndpointLocal;
    
    private List<ContractorContactDTO> contactsList;
    
    public ContractorsContacts() {
    }
    
    @PostConstruct
    public void init() {
        contactsList = new ArrayList<>();
    }
    
    public List<ContractorContactDTO> initContractorContracts(ContractorDTO contractor) {
        contactsList = contractorsContactsManagementEndpointLocal.getContractorsContacts();
        return contactsList;
    }

    public List<ContractorContactDTO> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<ContractorContactDTO> contactsList) {
        this.contactsList = contactsList;
    }
    
}
