package pl.lodz.p.project.core.dto.base;

import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
public class NamedDTO<T extends Serializable> extends BaseDTO<T> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
