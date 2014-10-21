package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocument;
import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocumentPK;

/**
 *
 * @author janiu
 */
public interface WarehouseDocumentsManagerLocal {
    
    WarehouseDocument getById(WarehouseDocumentPK id);

    List<WarehouseDocument> getWarehouseDocuments();
    
    WarehouseDocumentPK add(WarehouseDocument warehouseDocument);
    
    void edit(WarehouseDocument warehouseDocument);
    
    void remove(WarehouseDocument warehouseDocument);
}
