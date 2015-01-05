package pl.lodz.p.project.core.dto.document;

import com.google.common.collect.ComparisonChain;

import java.io.Serializable;
import java.util.Date;

public class FinancialReportDTO implements Serializable, Comparable<SaleDocumentDTO> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date reportDate;
    private Date reportStartDate;
    private Date reportEndDate;
    private int numberOfSales;
    private double averageSaleAmount;
    private double totalSalesAmount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public double getAverageSaleAmount() {
        return averageSaleAmount;
    }

    public void setAverageSaleAmount(double averageSaleAmount) {
        this.averageSaleAmount = averageSaleAmount;
    }

    public double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    @Override
    public int compareTo(SaleDocumentDTO saleDocumentDTO) {
        return ComparisonChain.start().compare(this.id, saleDocumentDTO.getId()).result();
    }
}
