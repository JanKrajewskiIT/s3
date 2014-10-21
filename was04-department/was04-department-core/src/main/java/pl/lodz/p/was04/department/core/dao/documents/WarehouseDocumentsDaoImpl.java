package pl.lodz.p.was04.department.core.dao.documents;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocument;
import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocumentPK;

/**
 *
 * @author janiu
 */
@Repository
@Transactional
public class WarehouseDocumentsDaoImpl extends AbstractCrudDao<WarehouseDocument, WarehouseDocumentPK> implements WarehouseDocumentsDao {

    public WarehouseDocumentsDaoImpl() {
        super(WarehouseDocument.class);
    }
    
}
