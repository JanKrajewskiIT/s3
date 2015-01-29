package pl.lodz.p.project.core.jsf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.contractor.AddressDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.service.account.UserService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Date;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class ConstantElements {

    @Autowired
    private UserService userService;

    public UserDTO getUser() {
        String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return userService.getUserByEmail(remoteUser);
    }

    public ContractorDTO getUserData() {
        ContractorDTO contractor = new ContractorDTO();
        contractor.setId(1l);
        contractor.setSymbol("ADMIN");
        contractor.setName("Admin Admiński");

        PostalCodeDTO postalCode = new PostalCodeDTO();
        postalCode.setCity("Warszawa");
        postalCode.setCode("55-555");

        AddressDTO address = new AddressDTO();
        address.setCity("Warszawa");
        address.setAddress("ul. Jakobinów 25a");
        address.setPostalCode(postalCode);

        contractor.setAddress(address);
        contractor.setNip("312-312-12-32");
        contractor.setEmail("admin.adminski@gmail.com");
        return contractor;
    }

    public String getCurrentDateValue() {
        return DateUtil.getCurrentDateValue();
    }

    public Date getCurrentDate() {
        return DateUtil.getCurrentDate();
    }
}
