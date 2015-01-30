package pl.lodz.p.project.core.dao.document.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;

/**
 * Created by milczu on 29.01.15.
 */
@Repository
@Transactional
public class ServiceProductsRequestDaoImpl extends AbstractCrudDao<ServiceProductsRequest, Long> implements ServiceProductsRequestDao {

    public ServiceProductsRequestDaoImpl() {
        super(ServiceProductsRequest.class);
    }
}
