package pl.lodz.p.project.core.jsf.menu;

import java.util.List;

/**
 *
 * @author milczu
 */
public class MenuItem {

    private String name;
    private String styleClass;
    private String targetUrl;
    private boolean rendered;
    private List<MenuActiveDefinition> activeDefinitions;
    private List<MenuItem> menuItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean getRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public List<MenuActiveDefinition> getActiveDefinitions() {
        return activeDefinitions;
    }

    public void setActiveDefinitions(List<MenuActiveDefinition> activeDefinitions) {
        this.activeDefinitions = activeDefinitions;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public boolean hasChildren() {
        return menuItems != null && !menuItems.isEmpty();
    }

    public boolean isActive(String currentPath) {
        if (activeDefinitions == null) {
            return false;
        }
        for (MenuActiveDefinition activeDefinition : activeDefinitions) {
            if (activeDefinition.isActive(currentPath)) {
                return true;
            }
        }
        return false;
    }

}
