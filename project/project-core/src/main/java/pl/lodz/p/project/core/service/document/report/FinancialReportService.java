package pl.lodz.p.project.core.service.document.report;

import pl.lodz.p.project.core.dto.document.report.FinancialReportDTO;

import java.util.List;

public interface FinancialReportService {

    FinancialReportDTO getOneById(Long id);

    List<FinancialReportDTO> getAll();

    void save(FinancialReportDTO financialReportDTO);

    void delete(FinancialReportDTO financialReportDTO);
}
