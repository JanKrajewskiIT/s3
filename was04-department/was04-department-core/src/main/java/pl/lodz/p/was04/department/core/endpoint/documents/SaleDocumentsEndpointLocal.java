package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.documents.SaleDocumentDTO;

/**
 *
 * @author janiu
 */
public interface SaleDocumentsEndpointLocal {

    SaleDocumentDTO getById(String id, Long whId);

    List<SaleDocumentDTO> getSaleDocuments();

    String add(SaleDocumentDTO saleDocument);

    void edit(SaleDocumentDTO saleDocument);

    void remove(SaleDocumentDTO saleDocument);
}
