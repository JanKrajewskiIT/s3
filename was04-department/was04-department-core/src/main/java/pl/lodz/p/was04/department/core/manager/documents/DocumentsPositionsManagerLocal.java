package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPositionPK;

/**
 *
 * @author janiu
 */
public interface DocumentsPositionsManagerLocal {
    
    DocumentPosition getById(DocumentPositionPK id);

    List<DocumentPosition> getDocumentsPositions();
    
    DocumentPositionPK add(DocumentPosition documentPosition);
    
    void edit(DocumentPosition documentPosition);
    
    void remove(DocumentPosition documentPosition);
}
