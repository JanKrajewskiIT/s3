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
@Named(value = "contractorsContactsBean")
@Scope("request")
public class ContractorsContacts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorContactService contractorsContactsManagementEndpointLocal;
    
    private List<ContractorContactDTO> contactsList;
    
    public ContractorsContacts() {
    }
    
    @PostConstruct
    public void init() {
        contactsList = new ArrayList<>();
    }
    
    public List<ContractorContactDTO> initContractorContracts(ContractorDTO contractor) {
        contactsList = contractorsContactsManagementEndpointLocal.getAll();
        return contactsList;
    }

    public List<ContractorContactDTO> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<ContractorContactDTO> contactsList) {
        this.contactsList = contactsList;
    }
    
}
