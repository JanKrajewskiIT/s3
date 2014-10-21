package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.DocumentsPositionsDao;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPositionPK;

/**
 *
 * @author janiu
 */
@Component
public class DocumentsPositionsManager implements DocumentsPositionsManagerLocal {

    @Autowired
    private DocumentsPositionsDao documentPositionDao;

    @RolesAllowed("documentManagement")
    @Override
    public DocumentPosition getById(DocumentPositionPK id) {
        return documentPositionDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<DocumentPosition> getDocumentsPositions() {
        return documentPositionDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public DocumentPositionPK add(DocumentPosition documentPosition) {
        documentPositionDao.save(documentPosition);
        return documentPosition.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(DocumentPosition documentPosition) {
        documentPositionDao.save(documentPosition);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(DocumentPosition documentPosition) {
        documentPositionDao.delete(documentPosition);
    }

}
