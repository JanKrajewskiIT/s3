package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.contractor.ContractorService;

import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class ContractorController extends EditObjectController<ContractorDTO> {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ContractorService service;

    @Autowired
    private PostalCodeListController postalCodeListController;

    @Override
    protected void createNew() {
        setSourceObject(new ContractorDTO());
        getSourceObject().getAddress().setPostalCode(new PostalCodeDTO());
        getSourceObject().setGroup(new ContractorGroupDTO());
    }

    @Override
    protected void save() {
        String code = getSourceObject().getAddress().getPostalCode().getCode();
        PostalCodeDTO postalCode = postalCodeListController.retrievePostalCode(code);
        getSourceObject().getAddress().setPostalCode(postalCode);
        super.save();
        //return "contractorsTable.xhtml?faces-redirect=true";
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

}

/*
    public boolean isViewCompany() {
        if(getSelectedContractor().getType() != null) {
            return getSelectedContractor().getType().equals("Firma");
        }
        return false;
    }
*/