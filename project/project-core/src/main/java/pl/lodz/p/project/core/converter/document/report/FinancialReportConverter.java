package pl.lodz.p.project.core.converter.document.report;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.report.FinancialReport;
import pl.lodz.p.project.core.dto.document.report.FinancialReportDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FinancialReportConverter implements Converter<FinancialReport, FinancialReportDTO> {

    @Override
    public FinancialReport convertDTO(FinancialReportDTO objectDTO) {
        FinancialReport entity = new FinancialReport();
        entity.setId(objectDTO.getId());
        entity.setVersion(objectDTO.getVersion());
        entity.setAverageSaleAmount(objectDTO.getAverageSaleAmount());
        entity.setNumberOfSales(objectDTO.getNumberOfSales());
        entity.setReportDate(objectDTO.getReportDate());
        entity.setReportEndDate(objectDTO.getReportEndDate());
        entity.setReportStartDate(objectDTO.getReportStartDate());
        entity.setTotalSalesAmount(objectDTO.getTotalSalesAmount());
        return entity;
    }

    @Override
    public FinancialReportDTO convertEntity(FinancialReport entity) {
        FinancialReportDTO objectDTO = new FinancialReportDTO();
        objectDTO.setId(entity.getId());
        objectDTO.setVersion(entity.getVersion());
        objectDTO.setAverageSaleAmount(entity.getAverageSaleAmount());
        objectDTO.setNumberOfSales(entity.getNumberOfSales());
        objectDTO.setReportDate(entity.getReportDate());
        objectDTO.setReportEndDate(entity.getReportEndDate());
        objectDTO.setReportStartDate(entity.getReportStartDate());
        objectDTO.setTotalSalesAmount(entity.getTotalSalesAmount());
        return objectDTO;
    }
}
