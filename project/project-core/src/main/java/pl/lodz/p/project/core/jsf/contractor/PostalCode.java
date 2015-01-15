package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.service.contractor.PostalCodeService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Janiu
 */
@Named(value = "postalCodeBean")
@Scope("request")
public class PostalCode implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PostalCodeService postalCodeService;

	private List<PostalCodeDTO> postalCodeList;

	public PostalCode() { }

	@PostConstruct
	public void init() {
		postalCodeList = postalCodeService.getAll();
	}

	public void fillCity(ContractorDTO contractor) {
		if (contractor.getAddress().getPostalCode() != null) {
			// TODO change from code to id
			// String code = contractor.getPostCode();
			// PostalCodeDTO postalCode =
			// postalCodesManagementEndpointLocal.getPostalCode(code);
			// contractor.setCity(postalCode.getCity());
		}
	}

	public List<PostalCodeDTO> getPostalCodeList() {
		return postalCodeList;
	}

	public void setPostalCodeList(List<PostalCodeDTO> postalCodeList) {
		this.postalCodeList = postalCodeList;
	}
	
}
