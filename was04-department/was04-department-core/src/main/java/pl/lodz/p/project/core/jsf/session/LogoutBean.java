package pl.lodz.p.project.core.jsf.session;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;

/**
 * Named bean responsible for user session invalidation.
 *
 * @author Łukasz Gadomski
 */
@Named(value = "logoutBean")
@Scope("request")
public class LogoutBean {

    /**
     * Invalidates user session.
     *
     * @return String - navigation String
     */
    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "login";
    }

}
