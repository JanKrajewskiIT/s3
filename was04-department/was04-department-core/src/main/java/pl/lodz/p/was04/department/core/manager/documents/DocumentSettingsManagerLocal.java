package pl.lodz.p.was04.department.core.manager.documents;


/**
 *
 * @author milczu
 */
public interface DocumentSettingsManagerLocal {

    String findDefaultDocumentPlace();

    void updateDefaultDocumentPlace(String newDocumentPlace);
}
