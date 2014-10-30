package pl.lodz.p.was04.department.core.service.document;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.document.SaleDocumentDTO;

/**
 *
 * @author Janiu
 */
public interface SaleDocumentsService {

    SaleDocumentDTO getById(Long id);

    List<SaleDocumentDTO> getSaleDocuments();

    String add(SaleDocumentDTO saleDocumentDTO);

    void edit(SaleDocumentDTO saleDocumentDTO);

    void remove(SaleDocumentDTO saleDocumentDTO);
}
