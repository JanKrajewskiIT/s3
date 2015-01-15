package pl.lodz.p.project.core.dto.contractor;

import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
public class AddressDTO implements Serializable {

    private PostalCodeDTO postalCode;
    private String city;
    private String address;

    public PostalCodeDTO getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCodeDTO postalCode) {
        this.postalCode = postalCode;
    }

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
}
