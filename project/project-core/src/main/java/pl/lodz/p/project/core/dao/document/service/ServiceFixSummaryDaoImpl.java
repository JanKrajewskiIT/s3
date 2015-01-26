package pl.lodz.p.project.core.dao.document.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;

/**
 * Created by milczu on 26.01.15.
 */
@Repository
@Transactional
public class ServiceFixSummaryDaoImpl extends AbstractCrudDao<ServiceFixSummary, Long> implements ServiceFixSummaryDao {

    public ServiceFixSummaryDaoImpl() {
        super(ServiceFixSummary.class);
    }
}
