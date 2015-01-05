package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface InternalInvoiceService {

	InternalInvoiceDTO getOneById(Long id);

    List<InternalInvoiceDTO> getAll();
    
}
