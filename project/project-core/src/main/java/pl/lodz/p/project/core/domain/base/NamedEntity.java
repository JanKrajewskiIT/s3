package pl.lodz.p.project.core.domain.base;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public abstract class NamedEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
