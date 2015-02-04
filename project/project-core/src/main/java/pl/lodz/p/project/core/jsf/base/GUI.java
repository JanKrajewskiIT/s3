package pl.lodz.p.project.core.jsf.base;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@Named("gui")
@Scope("view")
public class GUI implements Serializable {

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

    private void showMessage(FacesMessage.Severity aSeverity, String aMessage) {
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(aSeverity, aMessage, "")) ;
        update(":growl");
    }

    public void update(String... aComponents) {
        for (String aComp : aComponents) {
            RequestContext.getCurrentInstance().update(aComp);
        }
    }

    public void showWarnMessage(String aMessage) {
        showMessage(FacesMessage.SEVERITY_WARN, aMessage);
    }

}
