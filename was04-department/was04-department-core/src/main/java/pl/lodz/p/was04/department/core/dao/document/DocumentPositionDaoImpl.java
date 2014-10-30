package pl.lodz.p.was04.department.core.dao.document;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.document.DocumentPosition;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class DocumentPositionDaoImpl extends AbstractCrudDao<DocumentPosition, Long> implements DocumentPositionDao {
    
    public DocumentPositionDaoImpl() {
        super(DocumentPosition.class);
    }

	@Override
	@Transactional(readOnly = true)
    public void createAll(Iterable<DocumentPosition> entities) {
        for(DocumentPosition documentPosition : entities) {
            save(documentPosition);
        }
    }
    
}
