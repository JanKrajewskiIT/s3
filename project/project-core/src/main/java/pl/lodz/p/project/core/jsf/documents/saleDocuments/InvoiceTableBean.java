package pl.lodz.p.project.core.jsf.documents.saleDocuments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.sale.SaleDocumentService;
import pl.lodz.p.project.core.service.document.sale.SaleDocumentServiceImpl;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Łukasz
 */
@Named(value = "invoicesTableBean")
@Scope("view")
public class InvoiceTableBean extends EditPageableListController<SaleDocumentDTO> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SaleDocumentServiceImpl service;

    @PostConstruct
    private void init() {
        initStartPage(5, "symbol");
        search();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

    @Override
    public void edit(String id) {
        GUI.redirect("vatInvoice", id);
    }

}

