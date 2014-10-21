package pl.lodz.p.was04.department.core.dao.documents;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.Warehouse;

/**
 *
 * @author janiu
 */
@Repository
@Transactional
public class WarehousesDaoImpl extends AbstractCrudDao<Warehouse, Long> implements WarehousesDao {
    
    public WarehousesDaoImpl() {
        super(Warehouse.class);
    }

}
