package pl.lodz.p.project.core.dao.document.items;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.domain.document.items.DocumentPosition;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;

import java.util.ArrayList;

/**
 *
 * @author Janiu
 */
public interface DocumentPositionDao extends CrudDao<DocumentPosition, Long> {
    
    void createAll(Iterable<DocumentPosition> entities);
    
    ArrayList<DocumentPositionDTO> getDocumentPositions(String id);
}
