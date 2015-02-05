package pl.lodz.p.project.core.jsf.documents.service.action;

import pl.lodz.p.project.core.jsf.base.Action;

/**
 * Created by milczu on 02.02.15.
 */
public class CreateFixSummaryFromServiceDocumentAction extends Action {

    private final FixSummaryCreatable fixSummaryCreatable;

    public CreateFixSummaryFromServiceDocumentAction(FixSummaryCreatable fixSummaryCreatable) {
        super("Stwórz podsumowanie naprawy");
        this.fixSummaryCreatable = fixSummaryCreatable;
    }

    @Override
    public void call() {
        fixSummaryCreatable.createFixSummary();
    }
}
