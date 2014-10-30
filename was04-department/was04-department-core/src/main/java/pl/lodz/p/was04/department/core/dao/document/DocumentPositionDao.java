package pl.lodz.p.was04.department.core.dao.document;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.document.DocumentPosition;

/**
 *
 * @author Janiu
 */
public interface DocumentPositionDao extends CrudDao<DocumentPosition, Long> {
    
    void createAll(Iterable<DocumentPosition> entities);
}
