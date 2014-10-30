package pl.lodz.p.was04.department.core.service.document;


/**
 *
 * @author Milczu
 */
public interface DocumentSettingsService {
    
    String findDefaultDocumentPlace();
    
    void updateDefaultDocumentPlace(String newDocumentPlace);
}
