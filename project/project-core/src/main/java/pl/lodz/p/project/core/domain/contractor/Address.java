package pl.lodz.p.project.core.domain.contractor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 1, max = 40)
    @Column(name = "city")
    private String city;

    @Size(min = 0, max = 60)
    @Column(name = "address")
    private String address;

    @JoinColumn(name = "postal_code_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostalCode postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

}
