package pl.lodz.p.project.core.domain.base;

/**
 * @author Jan Krajewski
 */
public interface Versioned {

    Long getVersion();

    void setVersion(Long version);

}
