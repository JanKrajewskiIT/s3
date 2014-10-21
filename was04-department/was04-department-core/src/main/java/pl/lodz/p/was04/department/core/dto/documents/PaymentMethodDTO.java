package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.documents.PaymentMethod;

/**
 *
 * @author milczu, janiu
 */
public class PaymentMethodDTO implements Serializable, Comparable<PaymentMethodDTO>{
    
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private int maturity;
    private Long version;
    private boolean active;

    PaymentMethodDTO(PaymentMethod methodOfPaymentId) {
        this.id = methodOfPaymentId.getId();
        this.name = methodOfPaymentId.getName();
        this.maturity = methodOfPaymentId.getMaturity();
        this.version = methodOfPaymentId.getVersion();
    }

    public PaymentMethodDTO() {
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int compareTo(PaymentMethodDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
