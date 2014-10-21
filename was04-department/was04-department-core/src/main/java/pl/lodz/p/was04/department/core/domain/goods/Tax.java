package pl.lodz.p.was04.department.core.domain.goods;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.goods.TaxDTO;

/**
 *
 * @author Łukasz, milczu
 */
@Entity
@Table(name = "taxes")
public class Tax implements Serializable, Activable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @DecimalMax("99.99")
    @DecimalMin("0.00")
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;
    @NotNull
    @Column(name = "is_active")
    private boolean active = true;
    @Version
    private Long version = 1L;

    public Tax() {
    }

    public Tax(Long id) {
        this.id = id;
    }

    public Tax(TaxDTO taxes) {
        this.id = taxes.getId();
        this.name = taxes.getName();
        this.value = taxes.getValue();
        this.active = taxes.isActive();
        this.version = taxes.getVersion();
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tax)) {
            return false;
        }
        Tax other = (Tax) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.goods.Tax[ id=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
