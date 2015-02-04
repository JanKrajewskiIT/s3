package pl.lodz.p.project.core.dao.document.sale;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;

/**
 * @author Janiu
 */
public interface SaleDocumentDao extends CrudDao<SaleDocument, Long> {
    Page<SaleDocument> search(String searchQuery, PageRequest pageRequest);
}
