package pl.lodz.p.project.core.jsf.base;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("request")
public class GUI implements Serializable {

    public String redirect(String xhtml, String id) {
        return xhtml + ".xhtml?faces-redirect=true&id=" + id;
    }
}
