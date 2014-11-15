package pl.lodz.p.project.core.jsf.documents.saleDocuments;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.document.SaleDocumentDTO;
import pl.lodz.p.project.core.service.document.SaleDocumentService;

/**
 *
 * @author Łukasz
 */
@Named(value = "invoicesTableBean")
@Scope("request")
public class InvoiceTableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
    private SaleDocumentService saleDocumentService;

    private List<SaleDocumentDTO> invoices;

    /**
     * Creates a new instance of GoodsTable
     */
    public InvoiceTableBean() {
    }

    @PostConstruct
    public void init() {
        setInvoices(saleDocumentService.getAll());
    }

    public void removeInvoice(SaleDocumentDTO invoice) {
        getInvoices().remove(invoice);
        saleDocumentService.delete(invoice);
    }

    /**
     * @return the invoices
     */
    public List<SaleDocumentDTO> getInvoices() {
        return invoices;
    }

    /**
     * @param invoices the invoices to set
     */
    public void setInvoices(List<SaleDocumentDTO> invoices) {
        this.invoices = invoices;
    }

    
}
