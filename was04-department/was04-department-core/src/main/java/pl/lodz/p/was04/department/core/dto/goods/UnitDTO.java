package pl.lodz.p.was04.department.core.dto.goods;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.goods.Unit;

/**
 *
 * @author Łukasz, milczu
 */
public class UnitDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private int zeroPlaces;
    private boolean active = true;
    private Long version = 1L;

    public UnitDTO() {
    }

    public UnitDTO(Long id) {
        this.id = id;
    }

    public UnitDTO(Unit units) {
        this.id = units.getId();
        this.name = units.getName();
        this.zeroPlaces = units.getZeroPlaces();
        this.active = units.isActive();
        this.version = units.getVersion();
    }

    public UnitDTO(UnitDTO units) {
        this.id = units.getId();
        this.name = units.getName();
        this.zeroPlaces = units.getZeroPlaces();
        this.active = units.isActive();
        this.version = units.getVersion();
    }

    public UnitDTO(Long id, String name, short zeroPlaces) {
        this.id = id;
        this.name = name;
        this.zeroPlaces = zeroPlaces;
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
     * @return the zeroPlaces
     */
    public int getZeroPlaces() {
        return zeroPlaces;
    }

    /**
     * @param zeroPlaces the zeroPlaces to set
     */
    public void setZeroPlaces(int zeroPlaces) {
        this.zeroPlaces = zeroPlaces;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param isActive the active to set
     */
    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
