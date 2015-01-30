package pl.lodz.p.project.core.service.document.service;

import pl.lodz.p.project.core.domain.document.service.BaseDocumentService;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.service.base.AbstractService;

/**
 * Created by milczu on 30.01.15.
 */
public abstract class AbstractBaseService<E extends BaseDocumentService, D extends BaseServiceDocumentDTO> extends AbstractService<E, D> implements BaseService<E, D> {

    @Override
    public void markDocumentAsDone(Long documentId) {
        changeStatus(documentId, ServiceDocumentState.DONE);
    }

    @Override
    public void markDocumentAsInProgress(Long documentId) {
        changeStatus(documentId, ServiceDocumentState.IN_PROGRESS);
    }

    protected void changeStatus(Long documentId, ServiceDocumentState newState) {
        D document = getOneById(documentId);
        document.setState(newState);
        save(document);
    }
}
