package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;

/**
 *
 * @author Janiu
 */
public interface PostalCodeService {

    List<PostalCodeDTO> getAll();
    
    PostalCodeDTO getOneById(Long id);
    
}
