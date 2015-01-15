package pl.lodz.p.project.core.service.document.warehouse;

import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface InternalInvoiceGoodService {

	InternalInvoiceGoodDTO getOneById(Long id);

    List<InternalInvoiceGoodDTO> getAll();
    
}
