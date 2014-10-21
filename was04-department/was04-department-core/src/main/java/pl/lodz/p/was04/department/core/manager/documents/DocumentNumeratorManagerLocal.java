package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

/**
 *
 * @author milczu
 */
public interface DocumentNumeratorManagerLocal {

    String nextNumber(String documentType);
    
    boolean isAvailable(String symbol, String documentType);
    
    List<String> availableFormats();
    
    String currentFormat();
    
    void updateDocumentFormat(String newDocumentFormat);
}
