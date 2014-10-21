package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.MeanOfTransport;

/**
 *
 * @author janiu
 */
public interface MeansOfTransportManagerLocal {
    
    MeanOfTransport getById(Long id);

    List<MeanOfTransport> getMeansOfTransport();
    
    Long add(MeanOfTransport meanOfTransport);
    
    void edit(MeanOfTransport meanOfTransport);
    
    void remove(MeanOfTransport meanOfTransport);
}
