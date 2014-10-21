package pl.lodz.p.was04.department.core.domain.contractors;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.domain.Persistable;
import pl.lodz.p.was04.department.core.dto.contractors.PostalCodeDTO;

/**
 *
 * @author janiu
 */
@Entity
@Table(name = "postal_codes")
public class PostalCode implements Serializable, Persistable<String> {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "code")
    private String code;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "city")
    private String city;

    public PostalCode() {
    }

    public PostalCode(String code) {
        this.code = code;
    }

    public PostalCode(PostalCodeDTO postalCode) {
        this.code = postalCode.getCode();
        this.city = postalCode.getCity();
    }

    @Override
    public String getId() {
        return code;
    }
    
    public void setId(String id) {
        this.code = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostalCode)) {
            return false;
        }
        PostalCode other = (PostalCode) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.contractors.PostalCodes[ code=" + code + " ]";
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
