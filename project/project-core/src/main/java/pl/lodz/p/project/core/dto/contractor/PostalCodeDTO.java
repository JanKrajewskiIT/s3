package pl.lodz.p.project.core.dto.contractor;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Janiu
 */
public class PostalCodeDTO implements Serializable, Comparable<PostalCodeDTO> {

	private static final long serialVersionUID = 1L;
	 
    private Long id;
	private String code;
    private String city;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}

}
