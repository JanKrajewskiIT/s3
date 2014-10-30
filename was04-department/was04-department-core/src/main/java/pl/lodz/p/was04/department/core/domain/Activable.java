package pl.lodz.p.was04.department.core.domain;

/**
 *
 * @author Milczu
 */
public interface Activable extends BasePersistable {
    
    boolean isActive();
    
    void setActive(boolean active);
    
}
