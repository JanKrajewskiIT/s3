package pl.lodz.p.was04.department.core.dto.goods;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.goods.Tax;

/**
 *
 * @author Łukasz
 */
public class TaxDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private BigDecimal value;
    private boolean active = true;
    private Long version = 1L;

    public TaxDTO() {
    }

    public TaxDTO(Long id) {
        this.id = id;
    }

    public TaxDTO(Tax taxes) {
        this.id = taxes.getId();
        this.name = taxes.getName();
        this.value = taxes.getValue();
        this.active = taxes.isActive();
        this.version = taxes.getVersion();
    }

    public TaxDTO(TaxDTO taxes) {
        this.id = taxes.getId();
        this.name = taxes.getName();
        this.value = taxes.getValue();
        this.active = taxes.isActive();
        this.version = taxes.getVersion();
    }

    public TaxDTO(Long id, String name, String shortName, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the isActive
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }

    /**
     * @return the version
     */
    public long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
