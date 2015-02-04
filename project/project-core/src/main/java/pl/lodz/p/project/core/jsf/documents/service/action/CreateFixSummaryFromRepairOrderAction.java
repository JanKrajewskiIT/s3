package pl.lodz.p.project.core.jsf.documents.service.action;

import pl.lodz.p.project.core.jsf.base.Action;

/**
 * Created by milczu on 02.02.15.
 */
public class CreateFixSummaryFromRepairOrderAction extends Action {

    private final FixSummaryFromRepairOrderCreatable fixSummaryFromRepairOrderCreatable;

    public CreateFixSummaryFromRepairOrderAction(FixSummaryFromRepairOrderCreatable fixSummaryFromRepairOrderCreatable) {
        super("Stwórz podsumowanie naprawy");
        this.fixSummaryFromRepairOrderCreatable = fixSummaryFromRepairOrderCreatable;
    }

    @Override
    public void call() {
        fixSummaryFromRepairOrderCreatable.createFixSummary();
    }
}
