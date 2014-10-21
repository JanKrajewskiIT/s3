package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.goods.Unit;
import pl.lodz.p.was04.department.core.dto.goods.UnitDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.goods.UnitsManagerLocal;

/**
 *
 * @author Łukasz, milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class UnitsManagementEndpoint implements UnitsManagementEndpointLocal {

	@Autowired
    UnitsManagerLocal unitsManagerLocal;

    @RolesAllowed({"settings", "goodsManagement"})
    @Override
    public List<UnitDTO> getUnits() {
        return createUnitsDTOList(unitsManagerLocal.getUnits());
    }

    private List<UnitDTO> createUnitsDTOList(List<Unit> listOfEnties) {
        List<UnitDTO> unitsDTO = new ArrayList<>();
        for (int i = 0; i < listOfEnties.size(); i++) {
            unitsDTO.add(new UnitDTO(listOfEnties.get(i)));
        }
        return unitsDTO;
    }

    @RolesAllowed("goodsManagement")
    @Override
    public UnitDTO getUnit(Long id) {
        return new UnitDTO(unitsManagerLocal.getById(id));
    }

    @RolesAllowed("settings")
    @Override
    public Long add(UnitDTO unitDTO) {
        return unitsManagerLocal.add(new Unit(unitDTO));
    }

    @RolesAllowed("settings")
    @Override
    public void edit(UnitDTO unitDTO) {
        unitsManagerLocal.edit(new Unit(unitDTO));
    }

    @RolesAllowed("settings")
    @Override
    public void remove(UnitDTO unitDTO) {
        unitsManagerLocal.remove(new Unit(unitDTO));
    }
}
