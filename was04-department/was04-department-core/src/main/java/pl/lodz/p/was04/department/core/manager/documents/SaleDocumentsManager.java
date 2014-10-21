package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.DocumentsPositionsDao;
import pl.lodz.p.was04.department.core.dao.documents.SaleDocumentsDao;
import pl.lodz.p.was04.department.core.dao.goods.WarehousesGoodsDao;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocument;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocumentPK;
import pl.lodz.p.was04.department.core.domain.documents.Warehouse;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGood;
import pl.lodz.p.was04.department.core.domain.goods.WarehouseGoodPK;

/**
 *
 * @author janiu
 */
@Component
public class SaleDocumentsManager implements SaleDocumentsManagerLocal {

    @Autowired
    private SaleDocumentsDao saleDocumentDao;

    @Autowired
    private DocumentsPositionsDao documentsPositionsDao;

    @Autowired
    private WarehousesGoodsDao warehousesGoodsDao;
    
    @RolesAllowed("documentManagement")
    @Override
    public SaleDocument getById(SaleDocumentPK id) {
        return saleDocumentDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<SaleDocument> getSaleDocuments() {
        return saleDocumentDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public SaleDocumentPK add(SaleDocument saleDocument, List<DocumentPosition> documentPositions) {
        saleDocumentDao.save(saleDocument);
        documentsPositionsDao.createAll(documentPositions);
        if (saleDocument.isWarehouseResult()) {
            Warehouse warehouse = saleDocument.getWarehouse();
            for (DocumentPosition documentPosition : documentPositions) {
                Long goodId = documentPosition.getGood().getId();
                System.out.println("warehouse id: " + warehouse.getId() + ", good id: " + goodId);
                WarehouseGood warehouseGood = warehousesGoodsDao.findOne(new WarehouseGoodPK(warehouse.getId(), goodId));
                //TODO double availableQty = warehouseGood.getQuantity();
                double afterWarehouseResult = warehouseGood.invokeWarehouseResult(-documentPosition.getQuantity());

                if (afterWarehouseResult < 0.0) {
                    //TODO not commited  
                	//throw new WarehouseQuantityLimitExceededException(new GoodDTO(documentPosition.getGood()), availableQty);
                }
                warehousesGoodsDao.save(warehouseGood);
            }
        }

        return saleDocument.getId();

    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(SaleDocument saleDocument) {
        saleDocumentDao.save(saleDocument);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(SaleDocument saleDocument) {
        saleDocumentDao.delete(saleDocument);
    }

}
