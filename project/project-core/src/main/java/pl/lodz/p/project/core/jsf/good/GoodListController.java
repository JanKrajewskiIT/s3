package pl.lodz.p.project.core.jsf.good;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.good.GoodServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class GoodListController extends EditPageableListController<GoodDTO> {

    @Autowired
    private GoodServiceImpl service;

    private Double quantity;

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
    public String edit(String id) {
        return GUI.redirect("good", id);
    }
}
