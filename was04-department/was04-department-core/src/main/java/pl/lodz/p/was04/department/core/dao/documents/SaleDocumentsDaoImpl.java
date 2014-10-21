package pl.lodz.p.was04.department.core.dao.documents;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocument;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocumentPK;

/**
 *
 * @author janiu, milczu
 */
@Repository
@Transactional
public class SaleDocumentsDaoImpl extends AbstractCrudDao<SaleDocument, SaleDocumentPK> implements SaleDocumentsDao {
    
    public SaleDocumentsDaoImpl() {
        super(SaleDocument.class);
    }

	@Transactional(readOnly = true)
    public void create(SaleDocument saleDocument) {
        try {
            save(saleDocument);
            saleDocument = getEntityManager().merge(saleDocument);
        } catch(PersistenceException e) {
            System.out.println("---Exception: " + e.getClass());
            //TODO throw new DocumentSymbolAlreadyInUseException("Symbol dokumentu jest już zajęty");
        }
        
    }
    
}
