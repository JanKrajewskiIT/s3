package pl.lodz.p.project.core.jsf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.contractor.AddressDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.service.account.UserService;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class ConstantElements implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstantElements.class);

    @Autowired
    private UserService userService;

    public UserDTO getUser() {
        String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        UserDTO userDTO = userService.getUserByEmail(remoteUser);
        if (userDTO == null) {
            LOGGER.warn("Unable to find User by email: {}", remoteUser);
            userDTO = new UserDTO();
            userDTO.setFirstName("Admin");
            userDTO.setSecondName("Admiński");
            userDTO.setId(1L);
        }
        return userDTO;
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
