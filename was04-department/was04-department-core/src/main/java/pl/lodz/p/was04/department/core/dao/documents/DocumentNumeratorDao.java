package pl.lodz.p.was04.department.core.dao.documents;

/**
 *
 * @author milczu
 */
public interface DocumentNumeratorDao {
    
    String findPrevious(String documentType);
    
    boolean isAvailable(String symbol, String documentType);
}
