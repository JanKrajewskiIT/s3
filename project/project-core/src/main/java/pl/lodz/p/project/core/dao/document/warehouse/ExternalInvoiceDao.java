package pl.lodz.p.project.core.dao.document.warehouse;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;

/**
 * @author Jan Krajewski
 */
public interface ExternalInvoiceDao extends CrudDao<ExternalInvoice, Long> {

    Page<ExternalInvoice> search(String searchQuery, PageRequest pageRequest);

    public void updateQuantity(Long id, Double quantity);
}
