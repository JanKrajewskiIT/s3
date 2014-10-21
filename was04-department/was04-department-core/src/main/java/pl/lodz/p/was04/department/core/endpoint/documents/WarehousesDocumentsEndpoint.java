package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocument;
import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocumentPK;
import pl.lodz.p.was04.department.core.dto.documents.WarehouseDocumentDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.WarehouseDocumentsManagerLocal;

/**
 *
 * @author janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class WarehousesDocumentsEndpoint implements WarehousesDocumentsEndpointLocal {

    @Autowired
    private WarehouseDocumentsManagerLocal warehouseDocumentManager;

    @RolesAllowed("documentManagement")
    @Override
    public WarehouseDocumentDTO getById(WarehouseDocumentPK id) {
        return new WarehouseDocumentDTO(warehouseDocumentManager.getById(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<WarehouseDocumentDTO> getWarehouseDocuments() {
        List<WarehouseDocument> warehouseDocuments = warehouseDocumentManager.getWarehouseDocuments();
        List<WarehouseDocumentDTO> warehouseDocumentDTOs = new ArrayList<>();
        for (WarehouseDocument warehouseDocument : warehouseDocuments) {
            warehouseDocumentDTOs.add(new WarehouseDocumentDTO(warehouseDocument));
        }
        return warehouseDocumentDTOs;
    }

    @RolesAllowed("documentManagement")
    @Override
    public String add(WarehouseDocumentDTO warehouseDocument) {
        return warehouseDocumentManager.add(new WarehouseDocument(warehouseDocument)).getSymbol();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(WarehouseDocumentDTO warehouseDocument) {
        warehouseDocumentManager.edit(new WarehouseDocument(warehouseDocument));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(WarehouseDocumentDTO warehouseDocument) {
        warehouseDocumentManager.remove(new WarehouseDocument(warehouseDocument));
    }
}
