package pl.lodz.p.project.core.service.document.warehouse;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class InternalInvoiceGoodServiceImpl implements InternalInvoiceGoodService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public InternalInvoiceGoodDTO getOneById(Long id) {
        return null;
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<InternalInvoiceGoodDTO> getAll() {
        return null;
    }

}
