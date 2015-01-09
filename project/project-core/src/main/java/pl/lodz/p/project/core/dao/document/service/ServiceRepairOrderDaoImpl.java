package pl.lodz.p.project.core.dao.document.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.service.ServiceRepairOrder;

/**
 * Created by milczu on 09.01.15.
 */
@Repository
@Transactional
public class ServiceRepairOrderDaoImpl extends AbstractCrudDao<ServiceRepairOrder, Long> implements ServiceRepairOrderDao {

    public ServiceRepairOrderDaoImpl() {
        super(ServiceRepairOrder.class);
    }
}
