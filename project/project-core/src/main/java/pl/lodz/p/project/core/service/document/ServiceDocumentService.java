package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;

public interface ServiceDocumentService {

    List<BaseServiceDocumentDTO> getAllBaseDocuments();
}
