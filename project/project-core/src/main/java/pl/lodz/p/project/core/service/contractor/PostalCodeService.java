package pl.lodz.p.project.core.service.contractor;

import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface PostalCodeService {

    List<PostalCodeDTO> getAll();
    
    PostalCodeDTO getOneById(Long id);
    
}
