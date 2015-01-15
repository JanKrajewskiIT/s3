package pl.lodz.p.project.core.jsf.contractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.service.contractor.ContractorGroupService;
import pl.lodz.p.project.core.service.contractor.ContractorService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Janiu
 */
@Scope("request")
@Named(value = "contractorTemplateBean")
public class ContractorTemplateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorService contractorService;
    
    @Autowired
    private ContractorGroupService contractorGroupService;
    
    private ContractorDTO selectedContractor;
    
    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(id)) {
            selectedContractor = new ContractorDTO();
        } else {
            selectedContractor = contractorService.getOneById(Long.parseLong(id));
        }
    }    
   
    public void clear() {
    	selectedContractor = new ContractorDTO();
    }

    public String saveContractor() {
    	Long groupId = selectedContractor.getGroup().getId();
    	ContractorGroupDTO group = contractorGroupService.getOneById(groupId);
    	selectedContractor.setGroup(group);
        contractorService.save(selectedContractor);
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
