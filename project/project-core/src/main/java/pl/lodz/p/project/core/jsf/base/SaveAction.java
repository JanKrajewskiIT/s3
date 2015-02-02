package pl.lodz.p.project.core.jsf.base;

/**
 * Created by milczu on 02.02.15.
 */
public class SaveAction extends Action {

    private final SaveableForm saveableForm;

    public SaveAction(SaveableForm saveableForm) {
        super("Zapisz");
        this.saveableForm = saveableForm;
    }

    @Override
    public void call() {
        saveableForm.save();
    }
}
