package pl.lodz.p.project.core.jsf.base;

/**
 * Created by milczu on 02.02.15.
 */
public class ClearAction extends Action {

    private final ClearableForm clearableForm;

    public ClearAction(ClearableForm clearableForm) {
        super("Wyczyść", "@form");
        this.clearableForm = clearableForm;
    }

    @Override
    public void call() {
        clearableForm.clear();
    }
}
