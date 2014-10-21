package pl.lodz.p.was04.department.core.dao.documents;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPositionPK;

/**
 *
 * @author janiu
 */
public interface DocumentsPositionsDao extends CrudDao<DocumentPosition, DocumentPositionPK> {
    
    void createAll(Iterable<DocumentPosition> entities);
}
