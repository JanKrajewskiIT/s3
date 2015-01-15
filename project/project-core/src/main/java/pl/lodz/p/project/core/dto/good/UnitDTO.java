package pl.lodz.p.project.core.dto.good;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class UnitDTO extends NamedDTO<Long> implements Comparable<UnitDTO> {

	private static final long serialVersionUID = 1L;

	private Short zeroPlaces;

	public UnitDTO() { }

	public UnitDTO(UnitDTO unit) {
		setName(unit.getName());
		this.zeroPlaces = unit.getZeroPlaces();
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
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
