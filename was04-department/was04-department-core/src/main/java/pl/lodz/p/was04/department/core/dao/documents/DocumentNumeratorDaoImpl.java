package pl.lodz.p.was04.department.core.dao.documents;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author milczu
 */
@Repository
@Transactional
public class DocumentNumeratorDaoImpl implements DocumentNumeratorDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
    public String findPrevious(String documentType) {
        try {
            String table = determineTableName(documentType);
            return (String) entityManager.createNativeQuery("SELECT symbol FROM " + table + " WHERE type = '" + documentType + "' ORDER BY document_date DESC, symbol DESC LIMIT 1").getSingleResult();
        } catch (NoResultException e) {
            System.err.println("No result exception: " + e.getMessage());
            return null;
        }
    }

    private String determineTableName(String documentType) {
        if ("FV".equals(documentType)) {
            return "sale_documents";
        } else {
            return "warehouse_documents";
        }
    }

	@Override
	@Transactional(readOnly = true)
    public boolean isAvailable(String symbol, String documentType) {
        try {
            String table = determineTableName(documentType);
            String result = (String) entityManager.createNativeQuery("SELECT symbol FROM " + table + " WHERE type = '" + documentType + "' ORDER BY document_date DESC, symbol DESC LIMIT 1").getSingleResult();
            return result == null;
        } catch (NoResultException e) {
            System.err.println("No result exception: " + e.getMessage());
            return true;
        }
    }
}
