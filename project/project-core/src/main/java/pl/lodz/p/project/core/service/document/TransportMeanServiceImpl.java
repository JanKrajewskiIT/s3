package pl.lodz.p.project.core.service.document;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.TransportMean;
import pl.lodz.p.project.core.dto.document.TransportMeanDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Janiu
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class TransportMeanServiceImpl extends AbstractService<TransportMean, TransportMeanDTO> implements TransportMeanService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public TransportMeanDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<TransportMeanDTO> getAll() {
        return super.getAll();
    }

}
