package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.documents.WarehouseDTO;

/**
 *
 * @author janiu
 */
public interface WarehousesEndpointLocal {
    
    WarehouseDTO getById(Long id);

    List<WarehouseDTO> getWarehouses();
    
}
