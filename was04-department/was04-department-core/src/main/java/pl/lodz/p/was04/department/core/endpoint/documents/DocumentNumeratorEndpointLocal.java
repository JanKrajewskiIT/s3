package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

/**
 *
 * @author milczu
 */
public interface DocumentNumeratorEndpointLocal {

    String nextNumber(String documentType);

    boolean isAvailable(String symbol, String documentType);

    List<String> availableFormats();

    String currentFormat();
    
    void updateDocumentFormat(String newDocumentFormat);
}
