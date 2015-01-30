package pl.lodz.p.project.core.service.document.service;

import pl.lodz.p.project.core.domain.document.service.BaseDocumentService;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.service.base.ServiceRepository;

/**
 * Created by milczu on 30.01.15.
 */
public interface BaseService<E extends BaseDocumentService, D extends BaseServiceDocumentDTO> extends ServiceRepository<E, D> {

    void markDocumentAsInProgress(Long documentId);

    void markDocumentAsDone(Long documentId);

}
