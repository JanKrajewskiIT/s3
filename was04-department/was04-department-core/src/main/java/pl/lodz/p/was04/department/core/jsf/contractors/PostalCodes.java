package pl.lodz.p.was04.department.core.jsf.contractors;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;
import pl.lodz.p.was04.department.core.dto.contractors.PostalCodeDTO;
import pl.lodz.p.was04.department.core.endpoint.contractors.PostalCodesManagementEndpointLocal;

/**
 *
 * @author janiu
 */
@Named(value = "postalCodesBean")
@Scope("view")
public class PostalCodes implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Autowired
    private PostalCodesManagementEndpointLocal postalCodesManagementEndpointLocal;
    
    private List<PostalCodeDTO> postalCodesList;

    public PostalCodes() {
    }
    
    @PostConstruct
    public void init() {
        postalCodesList = postalCodesManagementEndpointLocal.getPostalCodes();
    }

    public void fillCity(ContractorDTO contractor) {
        if(contractor.getPostCode() != null) {
            String code = contractor.getPostCode();
            PostalCodeDTO postalCode = postalCodesManagementEndpointLocal.getPostalCode(code); 
            contractor.setCity(postalCode.getCity());
        }
            System.out.println(contractor.getPostCode() == null ? "NULL" : contractor.getPostCode());
    }
    
    public List<PostalCodeDTO> getPostalCodesList() {
        return postalCodesList;
    }

    public void setPostalCodesList(List<PostalCodeDTO> postalCodesList) {
        this.postalCodesList = postalCodesList;
    }
   
}
