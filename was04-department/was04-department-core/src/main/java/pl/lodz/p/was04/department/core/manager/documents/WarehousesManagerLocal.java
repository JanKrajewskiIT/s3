package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.Warehouse;

/**
 *
 * @author janiu
 */
public interface WarehousesManagerLocal {
    
    Warehouse getById(Long id);

    List<Warehouse> getWarehouses();
    
    Long add(Warehouse warehouse);
    
    void edit(Warehouse warehouse);
    
    void remove(Warehouse warehouse);
}
