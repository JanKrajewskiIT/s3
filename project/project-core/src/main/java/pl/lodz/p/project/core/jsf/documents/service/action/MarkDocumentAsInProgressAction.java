package pl.lodz.p.project.core.jsf.documents.service.action;

import pl.lodz.p.project.core.jsf.base.Action;

/**
 * Created by milczu on 02.02.15.
 */
public class MarkDocumentAsInProgressAction extends Action {

    private final DocumentStateChangeable documentStateChangeable;

    public MarkDocumentAsInProgressAction(DocumentStateChangeable documentStateChangeable) {
        super("Rozpocznij");
        this.documentStateChangeable = documentStateChangeable;
    }

    @Override
    public void call() {
        documentStateChangeable.markDocumentAsInProgress();
    }
}
