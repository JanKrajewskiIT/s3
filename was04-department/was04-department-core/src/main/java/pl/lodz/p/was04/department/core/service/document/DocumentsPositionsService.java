package pl.lodz.p.was04.department.core.service.document;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.document.DocumentPositionDTO;

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
