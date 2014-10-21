package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;

import pl.lodz.p.was04.department.core.domain.documents.Warehouse;

/**
 *
 * @author janiu
 */
public class WarehouseDTO implements Serializable, Comparable<WarehouseDTO>{

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String warehouseName;
    private String warehouseShortName;
    private boolean isDefault;
    private Long version = 1L;

    public WarehouseDTO(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.warehouseName = warehouse.getWarehouseName();
        this.warehouseShortName = warehouse.getWarehouseShortName();
        this.isDefault = warehouse.isDefault();
    }

    WarehouseDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseShortName() {
        return warehouseShortName;
    }

    public void setWarehouseShortName(String warehouseShortName) {
        this.warehouseShortName = warehouseShortName;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void seTDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public int compareTo(WarehouseDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}
