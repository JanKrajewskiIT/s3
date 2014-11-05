package pl.lodz.p.project.core.jsf.good;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.service.good.UnitService;

/**
 *
 * @author Łukasz
 */
@Named(value = "unitsBean")
@Scope("request")
public class UnitsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private UnitService unitsManagementEndpointLocal;

    private List<UnitDTO> unitsList;

    /**
     * Creates a new instance of Units
     */
    public UnitsBean() { }

    @PostConstruct
    public void init() {
        setUnitsList(unitsManagementEndpointLocal.getAll());
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
