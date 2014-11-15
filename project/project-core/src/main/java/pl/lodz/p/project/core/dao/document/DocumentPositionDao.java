package pl.lodz.p.project.core.dao.document;

import java.util.ArrayList;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.domain.document.DocumentPosition;
import pl.lodz.p.project.core.dto.document.DocumentPositionDTO;

/**
 *
 * @author Janiu
 */
public interface DocumentPositionDao extends CrudDao<DocumentPosition, Long> {
    
    void createAll(Iterable<DocumentPosition> entities);
    
    ArrayList<DocumentPositionDTO> getDocumentPositions(String id);
}
