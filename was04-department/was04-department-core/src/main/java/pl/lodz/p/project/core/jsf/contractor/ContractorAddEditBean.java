package pl.lodz.p.project.core.jsf.contractor;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.service.contractor.ContractorsGroupsService;
import pl.lodz.p.project.core.service.contractor.ContractorsService;

/**
 *
 * @author Janiu
 */
@Scope("request")
@Named(value = "contractorAddEditBean")
public class ContractorAddEditBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorsService contractorsManagementEndpointLocal;
    
    @Autowired
    private ContractorsGroupsService contractorsGroupsManagementEndpointLocal;
    
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
        if(getSelectedContractor().getType() != null) {
            return getSelectedContractor().getType().equals("Firma");
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
