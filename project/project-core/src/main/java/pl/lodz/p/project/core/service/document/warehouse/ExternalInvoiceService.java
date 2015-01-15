package pl.lodz.p.project.core.service.document.warehouse;

import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface ExternalInvoiceService {

	ExternalInvoiceDTO getOneById(Long id);

    List<ExternalInvoiceDTO> getAll();

    void save(ExternalInvoiceDTO invoice);
    
}
