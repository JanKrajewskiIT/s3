package pl.lodz.p.was04.department.core.jsf.goods;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.goods.UnitDTO;
import pl.lodz.p.was04.department.core.endpoint.goods.UnitsManagementEndpointLocal;

/**
 *
 * @author Łukasz
 */
@Named(value = "unitsBean")
@Scope("view")
public class UnitsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private UnitsManagementEndpointLocal unitsManagementEndpointLocal;

    private List<UnitDTO> unitsList;

    /**
     * Creates a new instance of Units
     */
    public UnitsBean() { }

    @PostConstruct
    public void init() {
        setUnitsList(unitsManagementEndpointLocal.getUnits());
    }

    /**
     * @return the unitsList
     */
    public List<UnitDTO> getUnitsList() {
        return unitsList;
    }

    /**
     * @param unitsList the unitsList to set
     */
    public void setUnitsList(List<UnitDTO> unitsList) {
        this.unitsList = unitsList;
    }
}
