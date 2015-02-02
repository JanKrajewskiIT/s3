package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.contractor.ContractorServiceImpl;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class ContractorListController extends EditPageableListController<ContractorDTO> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ContractorServiceImpl service;

    @PostConstruct
    private void init() {
        initStartPage(5, "name");
        search();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

    @Override
    public void edit(String id) {
        GUI.redirect("contractor", id);
    }

}
