package pl.lodz.p.project.core.service.document.items;

import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface TransportMeanService {
    
    TransportMeanDTO getOneById(Long id);

    List<TransportMeanDTO> getAll();
    
}
