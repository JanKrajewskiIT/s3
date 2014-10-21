package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.documents.Warehouse;
import pl.lodz.p.was04.department.core.dto.documents.WarehouseDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.WarehousesManagerLocal;

/**
 *
 * @author janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class WarehousesEndpoint implements WarehousesEndpointLocal {

    @Autowired
    private WarehousesManagerLocal warehouseManager;

    @RolesAllowed("documentManagement")
    @Override
    public WarehouseDTO getById(Long id) {
        return new WarehouseDTO(warehouseManager.getById(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<WarehouseDTO> getWarehouses() {
        List<Warehouse> warehouses = warehouseManager.getWarehouses();
        List<WarehouseDTO> warehouseDTOs = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            warehouseDTOs.add(new WarehouseDTO(warehouse));
        }
        return warehouseDTOs;
    }

}
