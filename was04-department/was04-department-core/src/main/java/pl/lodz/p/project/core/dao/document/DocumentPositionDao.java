package pl.lodz.p.project.core.dao.document;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.domain.document.DocumentPosition;

/**
 *
 * @author Janiu
 */
public interface DocumentPositionDao extends CrudDao<DocumentPosition, Long> {
    
    void createAll(Iterable<DocumentPosition> entities);
}
