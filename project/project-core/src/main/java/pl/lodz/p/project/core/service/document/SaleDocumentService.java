package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.SaleDocumentDTO;

/**
 *
 * @author Janiu
 */
public interface SaleDocumentService {

    SaleDocumentDTO getOneById(Long id);

    List<SaleDocumentDTO> getAll();

    void save(SaleDocumentDTO saleDocumentDTO);

    void delete(SaleDocumentDTO saleDocumentDTO);

}
