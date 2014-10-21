package pl.lodz.p.was04.department.core.jsf;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.jsf.menu.MenuConfigurationReader;
import pl.lodz.p.was04.department.core.jsf.menu.MenuItem;

/**
 *
 * @author milczu
 */
@Named
@Scope("request")
public class ApplicationConfigurationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SIDEBAR_MENU_CONFIG_FILE = "/config/sidebar-menu.xml";

    private List<MenuItem> sidebarMenuItems;

    /**
     * @return sidebar menu items for left menu 
     */
    public List<MenuItem> getSidebarMenuItems() {
        if (sidebarMenuItems == null) {
            sidebarMenuItems = new MenuConfigurationReader(SIDEBAR_MENU_CONFIG_FILE).readConfiguration();
        }
        return sidebarMenuItems;
    }
    
}
