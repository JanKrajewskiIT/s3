package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.good.GoodService;
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
    private GoodServiceImpl goodService;

    private Integer quantity;

    @PostConstruct
    private void init() {
        setService(goodService);
        page = goodService.search(searchQuery, pageRequest);
        setItems(page.getContent());
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
