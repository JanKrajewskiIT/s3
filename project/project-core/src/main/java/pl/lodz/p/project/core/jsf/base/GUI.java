package pl.lodz.p.project.core.jsf.base;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

    public static String catchId(String idColumn) {
        ExternalContext context =  FacesContext.getCurrentInstance().getExternalContext();
        return context.getRequestParameterMap().get(idColumn);
    }
}
