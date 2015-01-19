package pl.lodz.p.project.core.service.document.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.dao.document.sale.SaleDocumentDao;
import pl.lodz.p.project.core.domain.document.report.FinancialReport;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;
import pl.lodz.p.project.core.dto.document.report.FinancialReportDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.Date;
import java.util.List;

/**
 * @author Zychu
 */
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
    public FinancialReport save(FinancialReportDTO paymentMethodDTO) {
        paymentMethodDTO.setReportDate(new Date());
        fillAdditionInformation(paymentMethodDTO);
        return super.save(paymentMethodDTO);
    }

    private void fillAdditionInformation(FinancialReportDTO financialReportDTO) {
        int numberOfSales = 0;
        Double totalSalesAmount = 0d;
        List<SaleDocument> allSalesDocument = saleDocumentDao.findAll();
        for (SaleDocument saleDocument : allSalesDocument) {
            if (saleDocument.getDocumentDate().before(financialReportDTO.getReportEndDate())
                    && saleDocument.getDocumentDate().after(financialReportDTO.getReportStartDate())) {
                numberOfSales++;
                totalSalesAmount = totalSalesAmount + saleDocument.getPaidTotal();
            }
        }
        financialReportDTO.setTotalSalesAmount(totalSalesAmount.doubleValue());
        financialReportDTO.setNumberOfSales(numberOfSales);
        if (numberOfSales != 0) {
            financialReportDTO.setAverageSaleAmount(totalSalesAmount / numberOfSales);
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
