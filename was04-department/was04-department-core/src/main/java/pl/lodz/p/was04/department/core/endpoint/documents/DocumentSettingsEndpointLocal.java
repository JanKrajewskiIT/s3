package pl.lodz.p.was04.department.core.endpoint.documents;


/**
 *
 * @author milczu
 */
public interface DocumentSettingsEndpointLocal {
    
    String findDefaultDocumentPlace();
    
    void updateDefaultDocumentPlace(String newDocumentPlace);
}
