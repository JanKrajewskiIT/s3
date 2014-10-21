package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocumentPK;
import pl.lodz.p.was04.department.core.dto.documents.WarehouseDocumentDTO;

/**
 *
 * @author janiu
 */
public interface WarehousesDocumentsEndpointLocal {
    
    WarehouseDocumentDTO getById(WarehouseDocumentPK id);

    List<WarehouseDocumentDTO> getWarehouseDocuments();
    
    String add(WarehouseDocumentDTO warehouseDocument);
    
    void edit(WarehouseDocumentDTO warehouseDocument);
    
    void remove(WarehouseDocumentDTO warehouseDocument);
}
