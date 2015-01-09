package pl.lodz.p.project.core.service.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.dao.document.SaleDocumentDao;
import pl.lodz.p.project.core.domain.document.FinancialReport;
import pl.lodz.p.project.core.domain.document.SaleDocument;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Interceptors({TrackerInterceptor.class})
public class FinancialReportServiceImpl extends AbstractService<FinancialReport, FinancialReportDTO> implements FinancialReportService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @Autowired
    private SaleDocumentDao saleDocumentDao;

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
        paymentMethodDTO.setReportDate(new Date());
        fillAdditionInformation(paymentMethodDTO);
        super.save(paymentMethodDTO);
    }

    private void fillAdditionInformation(FinancialReportDTO financialReportDTO) {
        int numberOfSales = 0;
        BigDecimal totalSalesAmount = BigDecimal.ZERO;
        List<SaleDocument> allSalesDocument = saleDocumentDao.findAll();
        for (SaleDocument saleDocument : allSalesDocument) {
            if (saleDocument.getDocumentDate().before(financialReportDTO.getReportEndDate())
                    && saleDocument.getDocumentDate().after(financialReportDTO.getReportStartDate())) {
                numberOfSales++;
                totalSalesAmount = totalSalesAmount.add(saleDocument.getPaidTotal());
            }
        }
        financialReportDTO.setTotalSalesAmount(totalSalesAmount.doubleValue());
        financialReportDTO.setNumberOfSales(numberOfSales);
        if (numberOfSales != 0) {
            financialReportDTO.setAverageSaleAmount(totalSalesAmount.divide(new BigDecimal(numberOfSales)).doubleValue());
        } else {
            financialReportDTO.setAverageSaleAmount(0.0);
        }
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(FinancialReportDTO paymentMethodDTO) {
        super.delete(paymentMethodDTO);
    }

}
