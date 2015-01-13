package pl.lodz.p.project.core.dto.base;

import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
public class BaseDTO<T extends Serializable> implements Serializable {

    private T id;
    private Long version = 1L;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
