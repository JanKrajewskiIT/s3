package pl.lodz.p.was04.department.core.service.contractor;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.contractor.PostalCodeDTO;

/**
 *
 * @author Janiu
 */
public interface PostalCodesService {

    List<PostalCodeDTO> getPostalCodes();
    
    PostalCodeDTO getPostalCode(Long id);
}
