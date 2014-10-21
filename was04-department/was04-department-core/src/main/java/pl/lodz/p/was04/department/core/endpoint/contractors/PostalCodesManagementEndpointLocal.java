package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.contractors.PostalCodeDTO;

/**
 *
 * @author Janiu
 */
public interface PostalCodesManagementEndpointLocal {

    List<PostalCodeDTO> getPostalCodes();
    
    PostalCodeDTO getPostalCode(String code);
}
