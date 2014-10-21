package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.goods.TaxesDao;
import pl.lodz.p.was04.department.core.domain.goods.Tax;

/**
 *
 * @author Łukasz, milczu
 */
@Component
public class TaxesManager implements TaxesManagerLocal {

    @Autowired
    TaxesDao taxesDao;

    @RolesAllowed("goodsManagement")
    @Override
    public Tax getById(Long id) {
        return taxesDao.findOne(id);
    }

    @RolesAllowed({"settings", "goodsManagement"})
    @Override
    public List<Tax> getTaxes() {
        return taxesDao.findAll();
    }

    @RolesAllowed("settings")
    @Override
    public Long add(Tax tax) {
        taxesDao.save(tax);
        return tax.getId();
    }

    @RolesAllowed("settings")
    @Override
    public void edit(Tax tax) {
        taxesDao.save(tax);
    }

    @RolesAllowed("settings")
    @Override
    public void remove(Tax tax) {
        taxesDao.delete(tax);
    }
}
