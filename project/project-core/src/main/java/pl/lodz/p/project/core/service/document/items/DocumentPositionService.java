package pl.lodz.p.project.core.service.document.items;

import pl.lodz.p.project.core.domain.document.items.DocumentPosition;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.service.base.ServiceRepository;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface DocumentPositionService extends ServiceRepository<DocumentPosition, DocumentPositionDTO> {

	List<DocumentPositionDTO> getDocumentPositions(String documentSymbol);

}
