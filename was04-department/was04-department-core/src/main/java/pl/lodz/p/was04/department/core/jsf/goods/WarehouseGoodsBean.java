/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.jsf.goods;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.documents.WarehouseDTO;
import pl.lodz.p.was04.department.core.endpoint.documents.WarehousesEndpointLocal;

/**
 *
 * @author Łukasz Gadomski
 */
@Named(value = "warehouseGoodsBean")
@Scope("session")
public class WarehouseGoodsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private WarehousesEndpointLocal warehousesEndpoint;

    private List<WarehouseDTO> warehouses;
    private Long warehouseId;

    @PostConstruct
    public void init() {
        warehouses = warehousesEndpoint.getWarehouses();
        if (warehouses.get(0) != null) {
            warehouseId = warehouses.get(0).getId();
        }
    }

    /**
     * @return the warehouses
     */
    public List<WarehouseDTO> getWarehouses() {
        return warehouses;
    }

    /**
     * @param warehouses the warehouses to set
     */
    public void setWarehouses(List<WarehouseDTO> warehouses) {
        this.warehouses = warehouses;
    }

    /**
     * @return the warehouseId
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * @param warehouseId the warehouseId to set
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

}
