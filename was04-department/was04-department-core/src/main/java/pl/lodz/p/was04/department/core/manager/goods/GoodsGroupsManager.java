package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.goods.GoodsGroupsDao;
import pl.lodz.p.was04.department.core.domain.goods.GoodGroup;

/**
 *
 * @author Łukasz, milczu
 */
@Component
public class GoodsGroupsManager implements GoodsGroupsManagerLocal {

    @Autowired
    GoodsGroupsDao goodsGroupsDao;

    @RolesAllowed("goodsGroupManagement")
    @Override
    public GoodGroup getById(Long id) {
        return goodsGroupsDao.findOne(id);
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public List<GoodGroup> getGoodsGroups() {
        return goodsGroupsDao.findAll();
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public Long add(GoodGroup goodGroup) {
        goodsGroupsDao.save(goodGroup);
        return goodGroup.getId();
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public void edit(GoodGroup goodGroup) {
        goodsGroupsDao.save(goodGroup);
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public void remove(GoodGroup goodGroup) {
        goodsGroupsDao.delete(goodGroup);
    }
}
