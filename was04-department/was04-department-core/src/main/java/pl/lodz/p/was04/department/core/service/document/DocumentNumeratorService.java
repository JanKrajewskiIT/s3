package pl.lodz.p.was04.department.core.service.document;

import java.util.List;

/**
 *
 * @author Milczu
 */
public interface DocumentNumeratorService {

    String nextNumber(String documentType);

    boolean isAvailable(String symbol, String documentType);

    List<String> availableFormats();

    String currentFormat();
    
    void updateDocumentFormat(String newDocumentFormat);
}
