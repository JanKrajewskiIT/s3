package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.TransportMeanDTO;

/**
 *
 * @author Janiu
 */
public interface TransportMeanService {
    
    TransportMeanDTO getOneById(Long id);

    List<TransportMeanDTO> getAll();
    
}
