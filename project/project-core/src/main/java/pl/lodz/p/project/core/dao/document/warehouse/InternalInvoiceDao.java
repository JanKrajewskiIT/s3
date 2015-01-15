package pl.lodz.p.project.core.dao.document.warehouse;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;

/**
 * @author Jan Krajewski
 */
public interface InternalInvoiceDao extends CrudDao<InternalInvoice, Long> {

    Page<InternalInvoice> search(String searchQuery, PageRequest pageRequest);

}
