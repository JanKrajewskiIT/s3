package pl.lodz.p.project.core.jsf.good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.good.UnitService;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class UnitListController extends EditListController<UnitDTO> {

    @Autowired
    private UnitService service;

    @PostConstruct
    private void init() {
        initList();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

}
