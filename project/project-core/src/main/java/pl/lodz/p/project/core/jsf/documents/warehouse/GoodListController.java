package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.good.GoodServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class GoodListController extends EditListController<GoodDTO> {

    @Autowired
    private GoodServiceImpl service;

    @Autowired
    private GUI gui;

    private Double quantity;

    @PostConstruct
    private void init() {
        setService(service);
        initStartPage(5, "name");
        search();
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String edit(String id) {
        return gui.redirect("addEditGood", id);
    }
}
