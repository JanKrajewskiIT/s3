package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface ExternalInvoiceService {

	ExternalInvoiceDTO getOneById(Long id);

    List<ExternalInvoiceDTO> getAll();
    
}
