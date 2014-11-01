package pl.lodz.p.project.core.jsf.contractor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.service.contractor.PostalCodesService;

/**
 *
 * @author janiu
 */
@Named(value = "postalCodesBean")
@Scope("request")
public class PostalCodes implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Autowired
    private PostalCodesService postalCodesManagementEndpointLocal;
    
    private List<PostalCodeDTO> postalCodesList;

    public PostalCodes() {
    }
    
    @PostConstruct
    public void init() {
        postalCodesList = postalCodesManagementEndpointLocal.getPostalCodes();
    }

    public void fillCity(ContractorDTO contractor) {
        if(contractor.getPostalCode() != null) {
            // TODO change from code to id 
        	//String code = contractor.getPostCode();
            //PostalCodeDTO postalCode = postalCodesManagementEndpointLocal.getPostalCode(code); 
            //contractor.setCity(postalCode.getCity());
        }
            System.out.println(contractor.getPostalCode() == null ? "NULL" : contractor.getPostalCode());
    }
    
    public List<PostalCodeDTO> getPostalCodesList() {
        return postalCodesList;
    }

    public void setPostalCodesList(List<PostalCodeDTO> postalCodesList) {
        this.postalCodesList = postalCodesList;
    }
   
}
