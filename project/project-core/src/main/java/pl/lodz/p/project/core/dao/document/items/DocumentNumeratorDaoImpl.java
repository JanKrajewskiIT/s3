package pl.lodz.p.project.core.dao.document.items;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.domain.document.service.ServiceRepairOrder;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Milczu
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
        } else if("RW".equals(documentType) || "PW".equals(documentType)) {
            return "internal_invoices";
        } else if("FZ".equals(documentType)) {
            return "purchase_documents";
        } else if("WZ".equals(documentType) || "PZ".equals(documentType)) {
            return "external_invoices";
        } else if (ServiceRepairOrder.DOCUMENT_TYPE.equals(documentType)) {
            return "service_repair_orders";
        } else if (ServiceFixSummary.DOCUMENT_TYPE.equals(documentType)) {
            return "service_fix_summaries";
        } else if (ServiceProductsRequest.DOCUMENT_TYPE.equals(documentType)) {
            return "service_products_requests";
        }
        throw new RuntimeException("Not defined document: " + documentType);
    }

	@Override
	@Transactional(readOnly = true)
    public boolean isAvailable(String symbol, String documentType) {
        try {
            String table = determineTableName(documentType);
            String result = (String) entityManager.createNativeQuery("SELECT symbol FROM " + table + " WHERE type = '" + documentType + "' ORDER BY document_date DESC, symbol DESC LIMIT 1").getSingleResult();
            return result == null;
        } catch (NoResultException e) {
            return true;
        }
    }
}
