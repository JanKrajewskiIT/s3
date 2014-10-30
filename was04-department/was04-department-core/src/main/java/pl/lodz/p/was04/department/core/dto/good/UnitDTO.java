package pl.lodz.p.was04.department.core.dto.good;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu
 */
public class UnitDTO implements Serializable, Comparable<UnitDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private Short zeroPlaces;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getZeroPlaces() {
		return zeroPlaces;
	}

	public void setZeroPlaces(Short zeroPlaces) {
		this.zeroPlaces = zeroPlaces;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(UnitDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}
	
}
