package pl.lodz.p.was04.department.core.domain;

import org.springframework.data.domain.Persistable;

/**
 *
 * @author milczu, janiu
 */
public interface Activable extends Persistable<Long> {
    
    boolean isActive();
    
    void setActive(boolean active);
    
}
