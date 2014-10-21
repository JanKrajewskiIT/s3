package pl.lodz.p.was04.department.core.dto.contractors;

import java.io.Serializable;

import pl.lodz.p.was04.department.core.domain.contractors.PostalCode;

/**
 *
 * @author Janiu
 */
public class PostalCodeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
    private String city;

    public PostalCodeDTO() {
    }

    public PostalCodeDTO(String code) {
        this.code = code;
    }

    public PostalCodeDTO(PostalCode postalCode) {
        this.code = postalCode.getCode();
        this.city = postalCode.getCity();
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

}
