package pl.lodz.p.was04.department.core.dao.documents;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPositionPK;

/**
 *
 * @author janiu, milczu
 */
@Repository
@Transactional
public class DocumentsPositionsDaoImpl extends AbstractCrudDao<DocumentPosition, DocumentPositionPK> implements DocumentsPositionsDao {
    
    public DocumentsPositionsDaoImpl() {
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
