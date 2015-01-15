package pl.lodz.p.project.core.domain.good;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.base.NamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "units")
public class Unit extends NamedEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "zero_places")
    private Short zeroPlaces;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private Collection<Good> goodsCollection;

	public Short getZeroPlaces() {
		return zeroPlaces;
	}

	public void setZeroPlaces(Short zeroPlaces) {
		this.zeroPlaces = zeroPlaces;
	}

	@XmlTransient
    public Collection<Good> getGoodsCollection() {
        return goodsCollection;
    }

    public void setGoodsCollection(Collection<Good> goodsCollection) {
        this.goodsCollection = goodsCollection;
    }

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
