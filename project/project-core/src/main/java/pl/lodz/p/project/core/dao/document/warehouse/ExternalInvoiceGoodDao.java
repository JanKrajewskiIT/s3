package pl.lodz.p.project.core.dao.document.warehouse;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface ExternalInvoiceGoodDao extends CrudDao<ExternalInvoiceGood, Long> {

    List<ExternalInvoiceGoodDTO> getGoodsByInvoice(Long id);

}
