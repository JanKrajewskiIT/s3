package pl.lodz.p.project.core.service.document.warehouse;

import java.util.List;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface InternalInvoiceGoodService {

	InternalInvoiceGoodDTO getOneById(Long id);

    List<InternalInvoiceGoodDTO> getAll();
    
}
