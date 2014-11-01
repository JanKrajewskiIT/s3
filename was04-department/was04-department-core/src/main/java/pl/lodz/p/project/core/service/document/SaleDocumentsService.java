package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.SaleDocumentDTO;

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
