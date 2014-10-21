package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.goods.UnitsDao;
import pl.lodz.p.was04.department.core.domain.goods.Unit;

/**
 *
 * @author Łukasz, milczu
 */
@Component
public class UnitsManager implements UnitsManagerLocal {

    @Autowired
    UnitsDao unitsDao;

    @RolesAllowed({"settings", "goodsManagement"})
    @Override
    public List<Unit> getUnits() {
        return unitsDao.findAll();
    }

    @RolesAllowed("goodsManagement")
    @Override
    public Unit getById(Long id) {
        return unitsDao.findOne(id);
    }

    @RolesAllowed("settings")
    @Override
    public Long add(Unit unit) {
    	unitsDao.save(unit);
        return unit.getId();
    }

    @RolesAllowed("settings")
    @Override
    public void edit(Unit unit) {
    	unitsDao.save(unit);
    }

    @RolesAllowed("settings")
    @Override
    public void remove(Unit unit) {
    	unitsDao.delete(unit);
    }
}
