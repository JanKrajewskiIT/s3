package pl.lodz.p.project.core.domain.base;

/**
 *
 * @author Milczu
 */
public interface Activable extends BasePersistable {
    
    boolean isActive();
    
    void setActive(boolean active);
    
}
