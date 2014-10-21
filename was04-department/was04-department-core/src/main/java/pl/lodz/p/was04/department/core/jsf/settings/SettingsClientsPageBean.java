package pl.lodz.p.was04.department.core.jsf.settings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorGroupDTO;
import pl.lodz.p.was04.department.core.endpoint.contractors.ContractorsGroupsManagementEndpointLocal;
import pl.lodz.p.was04.department.core.manager.accountmanagement.AccountManagerLocal;

/**
 *
 * @author milczu
 */
@Named(value = "settingsClientsPageBean")
@Scope("view")
public class SettingsClientsPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ContractorGroupDTO newClientGroup = new ContractorGroupDTO();
    private List<ContractorGroupDTO> clientsGroups;
    
    @Autowired
    private ContractorsGroupsManagementEndpointLocal clientsGroupsManagement;
    
    @Autowired
    private AccountManagerLocal accountManager;

    @PostConstruct
    public void init() {
        loadClientsGroups();
    }

    private void loadClientsGroups() {
        clientsGroups = clientsGroupsManagement.getContractorsGroups();
    }
    
    public void saveNewClientGroup() {
        ContractorGroupDTO clientGroupToSave = new ContractorGroupDTO(newClientGroup);
        System.out.println("New client group: " + clientGroupToSave);
        
        Long id =  clientsGroupsManagement.add(clientGroupToSave);
        System.out.println("Saved id: " + id);
        loadClientsGroups();
        newClientGroup = new ContractorGroupDTO();
    }

    public void onClientGroupEdit(RowEditEvent event) {
        ContractorGroupDTO editedClientGroup = ((ContractorGroupDTO) event.getObject());
        clientsGroupsManagement.edit(editedClientGroup);
        loadClientsGroups();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano grupę: ", editedClientGroup.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeClientGroup(ContractorGroupDTO clientGroup) {
        clientsGroupsManagement.remove(clientGroup);
        loadClientsGroups();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usunięto grupę: ", clientGroup.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public ContractorGroupDTO getNewClientGroup() {
        return newClientGroup;
    }

    public List<ContractorGroupDTO> getClientsGroups() {
        return clientsGroups;
    }
}
