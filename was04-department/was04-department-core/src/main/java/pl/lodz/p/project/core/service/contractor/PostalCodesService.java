package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;

/**
 *
 * @author Janiu
 */
public interface PostalCodesService {

    List<PostalCodeDTO> getPostalCodes();
    
    PostalCodeDTO getPostalCode(Long id);
}
