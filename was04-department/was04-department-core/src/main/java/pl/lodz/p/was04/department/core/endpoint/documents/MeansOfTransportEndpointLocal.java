package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.documents.MeanOfTransportDTO;

/**
 *
 * @author janiu
 */
public interface MeansOfTransportEndpointLocal {
    
    MeanOfTransportDTO getById(Long id);

    List<MeanOfTransportDTO> getMeansOfTransport();
}
