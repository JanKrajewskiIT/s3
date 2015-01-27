package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.contractor.ContractorGroupService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Created by janiu on 27.01.15.
 */
@Named
@ViewScoped
public class ContractorGroupListController extends EditListController<ContractorGroupDTO> {

    @Autowired
    private ContractorGroupService service;

    @PostConstruct
    private void init() {
        setService(service);
    }

}
