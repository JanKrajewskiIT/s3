package pl.lodz.p.project.core.jsf.good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.good.GoodServiceImpl;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class GoodListController extends EditPageableListController<GoodDTO> {

    @Autowired
    private GoodServiceImpl service;

    private Double quantity = 1.00;

    @PostConstruct
    private void init() {
        initStartPage(5, "name");
        search();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public void edit(String id) {
        GUI.redirect("good", id);
    }
}
