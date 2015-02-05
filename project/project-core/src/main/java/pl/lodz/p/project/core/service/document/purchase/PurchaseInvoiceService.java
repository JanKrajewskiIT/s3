package pl.lodz.p.project.core.service.document.purchase;

import pl.lodz.p.project.core.domain.document.purchase.PurchaseInvoice;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.service.base.ServiceRepository;

/**
 *
 * @author Janiu
 */
public interface PurchaseInvoiceService extends ServiceRepository<PurchaseInvoice, PurchaseInvoiceDTO> {

}
