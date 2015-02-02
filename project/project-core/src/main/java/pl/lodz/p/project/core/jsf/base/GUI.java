package pl.lodz.p.project.core.jsf.base;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * @author Jan Krajewski
 */
@Named("gui")
@Scope("view")
public class GUI implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(GUI.class);

    public static void redirect(String xhtml) {
        redirect(xhtml, null);
    }

    public static void redirect(String xhtml, String id) {
        try {
            String context = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            String redirectURI = context + xhtml + ".xhtml?faces-redirect=true";
            if (isNotBlank(id)) {
                redirectURI += "&id=" + id;
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectURI);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
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
