package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.DocumentPositionPK;
import pl.lodz.p.was04.department.core.dto.documents.DocumentPositionDTO;

/**
 *
 * @author janiu
 */
public interface DocumentsPositionsEndpointLocal {

    DocumentPositionDTO getById(DocumentPositionPK id);

    List<DocumentPositionDTO> getDocumentsPositions();

    List<DocumentPositionDTO> getDocumentsPositions(String invoiceId, String wareHouseId);

    String saveDocumentPositions(List<DocumentPositionDTO> documentPositionDTOs);

    String edit(List<DocumentPositionDTO> documentPositionDTOs);
}
