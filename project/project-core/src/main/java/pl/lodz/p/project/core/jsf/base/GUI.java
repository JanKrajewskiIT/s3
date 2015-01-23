package pl.lodz.p.project.core.jsf.base;

/**
 * @author Jan Krajewski
 */
public final class GUI {

    public static String redirect(String xhtml) {
        return xhtml + ".xhtml?faces-redirect=true";
    }

    public static String redirect(String xhtml, String id) {
        return xhtml + ".xhtml?faces-redirect=true&id=" + id;
    }
}
