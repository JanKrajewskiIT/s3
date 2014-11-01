package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.TransportMeanDTO;

/**
 *
 * @author Janiu
 */
public interface TransportMeansService {
    
    TransportMeanDTO getById(Long id);

    List<TransportMeanDTO> getTransportMeans();
}
