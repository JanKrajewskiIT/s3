package pl.lodz.p.project.core.domain.document.items;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.base.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "transport_means")
public class TransportMean extends NamedEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
