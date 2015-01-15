package pl.lodz.p.project.core.dao.document.sale;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class SaleDocumentDaoImpl extends AbstractCrudDao<SaleDocument, Long> implements SaleDocumentDao {
    
    public SaleDocumentDaoImpl() {
        super(SaleDocument.class);
    }

}
