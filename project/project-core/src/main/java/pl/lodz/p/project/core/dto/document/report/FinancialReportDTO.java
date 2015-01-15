package pl.lodz.p.project.core.dto.document.report;

import com.google.common.collect.ComparisonChain;
import pl.lodz.p.project.core.dto.base.BaseDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;

import java.util.Date;

public class FinancialReportDTO extends BaseDTO<Long> implements Comparable<SaleDocumentDTO> {

    private static final long serialVersionUID = 1L;

    private Date reportDate;
    private Date reportStartDate;
    private Date reportEndDate;
    private Integer numberOfSales;
    private Double averageSaleAmount;
    private Double totalSalesAmount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getReportStartDate() {
        return reportStartDate;
    }

    public void setReportStartDate(Date reportStartDate) {
        this.reportStartDate = reportStartDate;
    }

    public Date getReportEndDate() {
        return reportEndDate;
    }

    public void setReportEndDate(Date reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    public Integer getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(Integer numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public Double getAverageSaleAmount() {
        return averageSaleAmount;
    }

    public void setAverageSaleAmount(Double averageSaleAmount) {
        this.averageSaleAmount = averageSaleAmount;
    }

    public Double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(Double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    @Override
    public int compareTo(SaleDocumentDTO saleDocumentDTO) {
        return ComparisonChain.start().compare(this.getId(), saleDocumentDTO.getId()).result();
    }
}
