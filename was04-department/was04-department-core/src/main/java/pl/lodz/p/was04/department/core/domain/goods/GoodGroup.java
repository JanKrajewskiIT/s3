package pl.lodz.p.was04.department.core.domain.goods;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.goods.GoodGroupDTO;

/**
 *
 * @author Łukasz, milczu
 */
@Entity
@Table(name = "goods_groups")
public class GoodGroup implements Serializable, Activable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "good_group_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active = true;
    @Version
    private Long version = 1L;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodGroup")
    private Collection<Good> goodsCollection;

    public GoodGroup() {
    }

    public GoodGroup(Long id) {
        this.id = id;
    }

    public GoodGroup(GoodGroupDTO goodsGroups) {
        this.id = goodsGroups.getId();
        this.name = goodsGroups.getName();
        this.active = goodsGroups.isActive();
        this.version = goodsGroups.getVersion();
    }

    @Override
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

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GoodGroup)) {
            return false;
        }
        GoodGroup other = (GoodGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.goods.GoodsGroup[ id=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
