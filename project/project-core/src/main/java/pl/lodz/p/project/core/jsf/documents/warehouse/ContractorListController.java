package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.contractor.ContractorServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class ContractorListController extends EditListController<ContractorDTO> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ContractorServiceImpl service;

    @Autowired
    private GUI gui;

    @PostConstruct
    private void init() {
        setService(service);
        initStartPage(5, "name");
        search();
    }

    @Override
    public String edit(String id) {
        return gui.redirect("contractorTemplate", id);
    }

}
