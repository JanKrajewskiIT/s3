package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.documents.MeanOfTransport;
import pl.lodz.p.was04.department.core.dto.documents.MeanOfTransportDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.MeansOfTransportManagerLocal;

/**
 *
 * @author janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class MeansOfTransportEndpoint implements MeansOfTransportEndpointLocal {

    @Autowired
    private MeansOfTransportManagerLocal meanOfTransportManager;

    @RolesAllowed("documentManagement")
    @Override
    public MeanOfTransportDTO getById(Long id) {
        return new MeanOfTransportDTO(meanOfTransportManager.getById(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<MeanOfTransportDTO> getMeansOfTransport() {
        List<MeanOfTransport> meansOfTransport = meanOfTransportManager.getMeansOfTransport();
        List<MeanOfTransportDTO> meansOfTransportDTOs = new ArrayList<>();
        for (MeanOfTransport meanOfTransport : meansOfTransport) {
            meansOfTransportDTOs.add(new MeanOfTransportDTO(meanOfTransport));
        }
        return meansOfTransportDTOs;
    }
}
