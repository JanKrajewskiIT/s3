package pl.lodz.p.project.core.service.document.warehouse;

import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface ExternalInvoiceGoodService {

	ExternalInvoiceGoodDTO getOneById(Long id);

    List<ExternalInvoiceGoodDTO> getAll();
    
}
