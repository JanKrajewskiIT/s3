package pl.lodz.p.project.core.jsf.good;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.good.TaxDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.good.TaxService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class TaxListController extends EditListController<TaxDTO> {

    @Autowired
    private TaxService service;

    @PostConstruct
    private void init() {
        setService(service);
    }

}
