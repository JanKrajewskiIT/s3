package pl.lodz.p.was04.department.core.jsf.contractors;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;
import pl.lodz.p.was04.department.core.endpoint.contractors.ContractorsGroupsManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.contractors.ContractorsManagementEndpointLocal;

/**
 *
 * @author Janiu
 */
@Scope("request")
@Named(value = "contractorAddEditBean")
public class ContractorAddEditBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorsManagementEndpointLocal contractorsManagementEndpointLocal;
    
    @Autowired
    private ContractorsGroupsManagementEndpointLocal contractorsGroupsManagementEndpointLocal;
    
    private ContractorDTO selectedContractor;
    
    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(id)) {
            selectedContractor = new ContractorDTO();
        } else {
            selectedContractor = contractorsManagementEndpointLocal.findById(Long.parseLong(id));
        }
    }
    
   
    public void clear() {
        setSelectedContractor(new ContractorDTO());
    }

    public String saveContractor() {
        getSelectedContractor().setGroup(contractorsGroupsManagementEndpointLocal.getContractorGroup(getSelectedContractor().getGroup().getId()));
        //TODO id changed from string to long, we need to check logic
        //if (StringUtils.isBlank(selectedContractor.getId())) {
        if(selectedContractor.getId() == null) {
        	contractorsManagementEndpointLocal.addContractor(selectedContractor);
        } else {
            contractorsManagementEndpointLocal.editContractor(selectedContractor);
        }
        return "contractorsTable.xhtml?faces-redirect=true";
    }
    
    public boolean isViewCompany() {
        if(getSelectedContractor().getContractorType() != null) {
            return getSelectedContractor().getContractorType().equals("Firma");
        }
        return false;
    }
    
    public ContractorDTO getSelectedContractor() {
        return selectedContractor;
    }

    public void setSelectedContractor(ContractorDTO selectedContractor) {
        this.selectedContractor = selectedContractor;
    }

}
