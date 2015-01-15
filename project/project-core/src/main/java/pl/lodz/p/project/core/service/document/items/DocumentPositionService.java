package pl.lodz.p.project.core.service.document.items;

import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface DocumentPositionService {

	DocumentPositionDTO getOneById(Long id);

	List<DocumentPositionDTO> getAll();

	void save(List<DocumentPositionDTO> documentPositionList);

	List<DocumentPositionDTO> getDocumentPositions(String documentSymbol);

}
