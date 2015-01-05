package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.DocumentPositionDTO;

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
