package pl.lodz.p.was04.department.core.service.document;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.document.TransportMeanDTO;

/**
 *
 * @author Janiu
 */
public interface TransportMeansService {
    
    TransportMeanDTO getById(Long id);

    List<TransportMeanDTO> getTransportMeans();
}
