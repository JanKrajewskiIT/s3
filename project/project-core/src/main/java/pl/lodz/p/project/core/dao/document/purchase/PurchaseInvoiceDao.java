package pl.lodz.p.project.core.dao.document.purchase;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.purchase.PurchaseInvoice;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;

/**
 * @author Janiu
 */
public interface PurchaseInvoiceDao extends CrudDao<PurchaseInvoice, Long> {
    Page<PurchaseInvoice> search(String searchQuery, PageRequest pageRequest);
}
