package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.WarehouseDocumentsDao;
import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocument;
import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocumentPK;

/**
 *
 * @author janiu
 */
@Component
public class WarehouseDocumentsManager implements WarehouseDocumentsManagerLocal {

    @Autowired
    private WarehouseDocumentsDao warehouseDao;

    @RolesAllowed("documentManagement")
    @Override
    public WarehouseDocument getById(WarehouseDocumentPK id) {
        return warehouseDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<WarehouseDocument> getWarehouseDocuments() {
        return warehouseDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public WarehouseDocumentPK add(WarehouseDocument warehouseDocument) {
        warehouseDao.save(warehouseDocument);
        return warehouseDocument.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(WarehouseDocument warehouseDocument) {
        warehouseDao.save(warehouseDocument);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(WarehouseDocument warehouseDocument) {
        warehouseDao.delete(warehouseDocument);
    }

}
