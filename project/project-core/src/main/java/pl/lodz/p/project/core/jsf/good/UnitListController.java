package pl.lodz.p.project.core.jsf.good;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.good.UnitService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class UnitListController extends EditListController<UnitDTO> {

    @Autowired
    private UnitService service;

    @PostConstruct
    private void init() {
        setService(service);
    }

}
