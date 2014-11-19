package pl.lodz.p.project.core.domain.document;

import pl.lodz.p.project.core.domain.Activable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "financial_reports")
public class FinancialReport implements Serializable, Activable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financial_report_id")
    private Long id;

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
    private int numberOfSales;

    @Basic(optional = false)
    @NotNull
    @Column(name = "average_sale_amount")
    private int averageSaleAmount;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total_sales_amount")
    private int totalSalesAmount;

    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean active;

    @Version
    private long version;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public int getAverageSaleAmount() {
        return averageSaleAmount;
    }

    public void setAverageSaleAmount(int averageSaleAmount) {
        this.averageSaleAmount = averageSaleAmount;
    }

    public int getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(int totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}