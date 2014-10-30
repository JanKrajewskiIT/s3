package pl.lodz.p.was04.department.core.dao.document;

/**
 *
 * @author Milczu
 */
public interface DocumentNumeratorDao {
    
    String findPrevious(String documentType);
    
    boolean isAvailable(String symbol, String documentType);
}
