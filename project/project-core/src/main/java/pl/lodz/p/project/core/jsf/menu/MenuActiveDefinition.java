package pl.lodz.p.project.core.jsf.menu;

public class MenuActiveDefinition {
    
    private final StringCompareOperation compare;
    private final String requestPath;
    
    public MenuActiveDefinition(String requestPath, StringCompareOperation compare) {
        this.requestPath = requestPath;
        this.compare = compare;
    }

    public StringCompareOperation getCompare() {
        return compare;
    }

    public String getRequestPath() {
        return requestPath;
    }
    
    public boolean isActive(String currentPath) {
        return compare.apply(requestPath, currentPath);
    }
    
}
