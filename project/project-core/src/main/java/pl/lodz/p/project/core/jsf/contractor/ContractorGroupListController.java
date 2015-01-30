package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.contractor.ContractorGroupService;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class ContractorGroupListController extends EditListController<ContractorGroupDTO> {

    @Autowired
    private ContractorGroupService service;

    @PostConstruct
    private void init() {
        initList();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

}
