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
    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseDTO baseDTO = (BaseDTO) o;

        if (id != null ? !id.equals(baseDTO.id) : baseDTO.id != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
