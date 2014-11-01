package pl.lodz.p.project.core.domain;

/**
 *
 * @author Milczu
 */
public interface Activable extends BasePersistable {
    
    boolean isActive();
    
    void setActive(boolean active);
    
}
