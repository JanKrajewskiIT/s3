package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class InvoiceGoodListController extends EditListController<InternalInvoiceGoodDTO> {

    private boolean inAddState = false;

    @PostConstruct
    private void init() { }

    public void changeState() {
        setVisible(false);
    }

}