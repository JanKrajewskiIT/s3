package pl.lodz.p.project.core.dto.contractor;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.BaseDTO;

/**
 *
 * @author Janiu
 */
public class PostalCodeDTO extends BaseDTO<Long> implements Comparable<PostalCodeDTO> {

	private static final long serialVersionUID = 1L;

	private String code;
    private String city;

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(PostalCodeDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
