package pl.lodz.p.project.core.service.document.warehouse;

import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface InternalInvoiceService {

    InternalInvoiceDTO getOneById(Long id);

    List<InternalInvoiceDTO> getAll();

    void save(InternalInvoiceDTO invoice);

}