package pl.lodz.p.project.core.dao.document.report;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.report.FinancialReport;

@Repository
@Transactional
public class FinancialReportDaoImpl extends AbstractCrudDao<FinancialReport, Long> implements FinancialReportDao {

    public FinancialReportDaoImpl() {
        super(FinancialReport.class);
    }
}
