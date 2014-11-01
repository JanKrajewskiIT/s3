package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.DocumentPositionDTO;

/**
 *
 * @author Janiu
 */
public interface DocumentsPositionsService {

    DocumentPositionDTO getById(Long id);

    List<DocumentPositionDTO> getDocumentsPositions();

    String saveDocumentPositions(List<DocumentPositionDTO> documentPositionList);

    String edit(List<DocumentPositionDTO> documentPositionList);
}
