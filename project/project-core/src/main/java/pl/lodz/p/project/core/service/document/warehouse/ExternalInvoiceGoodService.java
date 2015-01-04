package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface ExternalInvoiceGoodService {

	ExternalInvoiceGoodDTO getOneById(Long id);

    List<ExternalInvoiceGoodDTO> getAll();
    
}
