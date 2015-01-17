package pl.lodz.p.project.core.dao.document.warehouse;

import org.apache.poi.util.Internal;
import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;

import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public interface InternalInvoiceGoodDao extends CrudDao<InternalInvoiceGood, Long> {

    List<InternalInvoiceGoodDTO> getGoodsByInvoice(Long id);

}
