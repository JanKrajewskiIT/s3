package pl.lodz.p.project.core.jsf.base;

/**
 * @author Jan Krajewski
 */
public abstract class Action implements Callable {

    private String name;
    private String update;

    public Action(String name, String update) {
        this.name = name;
        this.update = update;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
