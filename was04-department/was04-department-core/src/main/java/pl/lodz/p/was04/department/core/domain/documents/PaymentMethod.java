package pl.lodz.p.was04.department.core.domain.documents;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.documents.PaymentMethodDTO;

/**
 *
 * @author milczu
 */
@Entity
@Table(name = "methods_of_payment")
public class PaymentMethod implements Serializable, Activable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mop_id")
    private Long id;

    private String name;

    private int maturity;

    @NotNull
    @Column(name = "is_active")
    private boolean active = true;

    @Version
    private Long version = 1L;
    
    public PaymentMethod(){
        
    }

    public PaymentMethod(PaymentMethodDTO methodOfPayment) {
        this.id = methodOfPayment.getId();
        this.maturity = methodOfPayment.getMaturity();
        this.name = methodOfPayment.getName();
        this.version = methodOfPayment.getVersion();
        this.active = methodOfPayment.isActive();
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

    public int getMaturity() {
        return maturity;
    }

    public void setMaturity(int maturity) {
        this.maturity = maturity;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.documents.PaymentMethod[ id=" + id + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
