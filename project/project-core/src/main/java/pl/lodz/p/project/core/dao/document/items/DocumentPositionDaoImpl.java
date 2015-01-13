package pl.lodz.p.project.core.dao.document.items;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.items.DocumentPosition;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class DocumentPositionDaoImpl extends AbstractCrudDao<DocumentPosition, Long> implements DocumentPositionDao {

	public DocumentPositionDaoImpl() {
		super(DocumentPosition.class);
	}

	@Override
	@Transactional(readOnly = true)
	public void createAll(Iterable<DocumentPosition> entities) {
		for (DocumentPosition documentPosition : entities) {
			save(documentPosition);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DocumentPositionDTO> getDocumentPositions(String documentSymbol) {
		List result = entityManager.createNativeQuery("SELECT * FROM documents_positions WHERE symbol = '" + documentSymbol + "'").getResultList();
		return (ArrayList<DocumentPositionDTO>) result;
	}

}
