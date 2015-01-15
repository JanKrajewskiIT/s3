package pl.lodz.p.project.core.dto.good;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class TaxDTO extends NamedDTO<Long> implements Comparable<TaxDTO> {

	private static final long serialVersionUID = 1L;

    private Double value;

    public TaxDTO() { }
    
    public TaxDTO(TaxDTO tax) {
    	setName(tax.getName());
    	this.value = tax.getValue();
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(TaxDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
