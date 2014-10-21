package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocument;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocumentPK;

/**
 *
 * @author janiu
 */
public interface SaleDocumentsManagerLocal {
    
    SaleDocument getById(SaleDocumentPK id);

    List<SaleDocument> getSaleDocuments();
    
    SaleDocumentPK add(SaleDocument saleDocument, List<DocumentPosition> documentPositions);
    
    void edit(SaleDocument saleDocument);
    
    void remove(SaleDocument saleDocument);
}
