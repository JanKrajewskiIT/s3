package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPositionPK;
import pl.lodz.p.was04.department.core.dto.documents.DocumentPositionDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.DocumentsPositionsManagerLocal;

/**
 *
 * @author janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentsPositionsEndpoint implements DocumentsPositionsEndpointLocal {

    @Autowired
    private DocumentsPositionsManagerLocal documentPositionManager;

    @RolesAllowed("documentManagement")
    @Override
    public DocumentPositionDTO getById(DocumentPositionPK id) {
        return new DocumentPositionDTO(documentPositionManager.getById(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<DocumentPositionDTO> getDocumentsPositions() {
        List<DocumentPosition> documentsPositions = documentPositionManager.getDocumentsPositions();
        List<DocumentPositionDTO> documentsPositionDTOs = new ArrayList<>();
        for (DocumentPosition documentPosition : documentsPositions) {
            documentsPositionDTOs.add(new DocumentPositionDTO(documentPosition));
        }
        return documentsPositionDTOs;
    }

    @Override
    public String saveDocumentPositions(List<DocumentPositionDTO> documentPositionDTOs) {
        for (int i = 0; i < documentPositionDTOs.size(); i++) {
            documentPositionManager.add(new DocumentPosition(documentPositionDTOs.get(i)));
        }
        return "Data Saved";
    }

    @Override
    public List<DocumentPositionDTO> getDocumentsPositions(String invoiceId, String wareHouseId) {
        List<DocumentPosition> documentsPositions = documentPositionManager.getDocumentsPositions();
        List<DocumentPositionDTO> documentsPositionDTOs = new ArrayList<>();
        for (DocumentPosition documentPosition : documentsPositions) {
            if (documentPosition.getId().getDocumentSymbol().equalsIgnoreCase(invoiceId) && documentPosition.getId().getWarehouseId().equals(wareHouseId)) {
                documentsPositionDTOs.add(new DocumentPositionDTO(documentPosition));
            }
        }
        return documentsPositionDTOs;
    }

    @Override
    public String edit(List<DocumentPositionDTO> documentPositionDTOs) {
        for (int i = 0; i < documentPositionDTOs.size(); i++) {
            documentPositionManager.edit(new DocumentPosition(documentPositionDTOs.get(i)));
        }
        return "Data Saved";
    }
}
