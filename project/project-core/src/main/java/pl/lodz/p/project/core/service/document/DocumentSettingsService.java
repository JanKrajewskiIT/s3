package pl.lodz.p.project.core.service.document;


/**
 *
 * @author Milczu
 */
public interface DocumentSettingsService {
    
    String findDefaultDocumentPlace();
    
    void updateDefaultDocumentPlace(String newDocumentPlace);
}
