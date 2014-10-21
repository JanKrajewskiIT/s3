package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.WarehousesDao;
import pl.lodz.p.was04.department.core.domain.documents.Warehouse;

/**
 *
 * @author janiu
 */
@Component
public class WarehousesManager implements WarehousesManagerLocal {

    @Autowired
    private WarehousesDao warehouseDao;

    @RolesAllowed("documentManagement")
    @Override
    public Warehouse getById(Long id) {
        return warehouseDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<Warehouse> getWarehouses() {
        return warehouseDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(Warehouse warehouse) {
    	warehouseDao.save(warehouse);
        return warehouse.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(Warehouse warehouse) {
    	warehouseDao.save(warehouse);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(Warehouse warehouse) {
    	warehouseDao.delete(warehouse);
    }

}
