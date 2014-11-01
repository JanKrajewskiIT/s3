package pl.lodz.p.project.core.service.document;

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
