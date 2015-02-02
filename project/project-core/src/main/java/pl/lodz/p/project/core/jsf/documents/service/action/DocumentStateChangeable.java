package pl.lodz.p.project.core.jsf.documents.service.action;

/**
 * Created by milczu on 02.02.15.
 */
public interface DocumentStateChangeable {

    void markDocumentAsInProgress();

    void markDocumentAsDone();
}
