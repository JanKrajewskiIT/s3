package pl.lodz.p.project.core.converter.document;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.document.FinancialReport;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FinancialReportConverter implements Converter<FinancialReport, FinancialReportDTO> {

    @Override
    public FinancialReport convertDTO(FinancialReportDTO objectDTO) {
        FinancialReport report = new FinancialReport();
        report.setId(objectDTO.getId());
        report.setAverageSaleAmount(objectDTO.getAverageSaleAmount());
        report.setNumberOfSales(objectDTO.getNumberOfSales());
        report.setReportDate(objectDTO.getReportDate());
        report.setReportEndDate(objectDTO.getReportEndDate());
        report.setReportStartDate(objectDTO.getReportStartDate());
        report.setTotalSalesAmount(objectDTO.getTotalSalesAmount());
        return report;
    }

    @Override
    public FinancialReportDTO convertEntity(FinancialReport entity) {
        FinancialReportDTO dto = new FinancialReportDTO();
        dto.setId(entity.getId());
        dto.setAverageSaleAmount(entity.getAverageSaleAmount());
        dto.setNumberOfSales(entity.getNumberOfSales());
        dto.setReportDate(entity.getReportDate());
        dto.setReportEndDate(entity.getReportEndDate());
        dto.setReportStartDate(entity.getReportStartDate());
        dto.setTotalSalesAmount(entity.getTotalSalesAmount());
        return dto;
    }
}
