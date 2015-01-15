package pl.lodz.p.project.core.domain.document.report;

import pl.lodz.p.project.core.domain.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "financial_reports")
public class FinancialReport extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "report_date")
    @Temporal(TemporalType.DATE)
    private Date reportDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "report_start_date")
    @Temporal(TemporalType.DATE)
    private Date reportStartDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "report_end_date")
    @Temporal(TemporalType.DATE)
    private Date reportEndDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "number_of_sales")
    private Integer numberOfSales;

    @Basic(optional = false)
    @NotNull
    @Column(name = "average_sale_amount")
    private Double averageSaleAmount;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total_sales_amount")
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

}