package pl.lodz.p.project.core.dao.document;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.FinancialReport;

@Repository
@Transactional
public class FinancialReportDaoImpl extends AbstractCrudDao<FinancialReport, Long> implements FinancialReportDao {

    public FinancialReportDaoImpl() {
        super(FinancialReport.class);
    }
}
