package pl.lodz.p.project.core.service.document;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.domain.document.FinancialReport;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

@Component
@Interceptors({TrackerInterceptor.class})
public class FinancialReportServiceImpl extends AbstractService<FinancialReport, FinancialReportDTO> implements FinancialReportService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public FinancialReportDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<FinancialReportDTO> getAll() {
        return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(FinancialReportDTO paymentMethodDTO) {
        super.save(paymentMethodDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(FinancialReportDTO paymentMethodDTO) {
        super.delete(paymentMethodDTO);
    }

}
