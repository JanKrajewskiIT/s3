package pl.lodz.p.project.core.jsf.contractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.contractor.ContractorGroupService;
import pl.lodz.p.project.core.service.contractor.ContractorService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Janiu
 */
@Named
@ViewScoped
public class ContractorController extends EditObjectController<ContractorDTO> {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorService service;

    @Autowired
    private ContractorGroupService contractorGroupService;

    @Autowired
    private PostalCodeListController postalCodeListController;

    private List<ContractorGroupDTO> contractorGroupList;

    @PostConstruct
    private void init() {
        String id = GUI.catchId("id");
        if (StringUtils.isBlank(id)) {
            setSourceObject(new ContractorDTO());
        } else {
            setSourceObject(service.getOneById(Long.parseLong(id)));
        }
        contractorGroupList = contractorGroupService.getAll();
        getSourceObject().getAddress().setPostalCode(new PostalCodeDTO());
        getSourceObject().setGroup(new ContractorGroupDTO());
    }

    public List<ContractorGroupDTO> getContractorGroupList() {
        return contractorGroupList;
    }

    public void setContractorGroupList(List<ContractorGroupDTO> contractorGroupList) {
        this.contractorGroupList = contractorGroupList;
    }

    @Override
    public void save() {
        String code = getSourceObject().getAddress().getPostalCode().getCode();
        PostalCodeDTO postalCode = postalCodeListController.retrievePostalCode(code);
        getSourceObject().getAddress().setPostalCode(postalCode);
        service.save(getSourceObject());
    }

/*
    @PostConstruct
    public void init() {

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
*/

}
