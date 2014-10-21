package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.goods.GoodsDao;
import pl.lodz.p.was04.department.core.dao.goods.GoodsGroupsDao;
import pl.lodz.p.was04.department.core.dao.goods.UnitsDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.goods.Good;

/**
 *
 * @author Łukasz
 */
@Component
public class GoodsManager implements GoodsManagerLocal {

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    GoodsGroupsDao goodsGroupsDao;

    @Autowired
    UnitsDao unitsDao;

    @RolesAllowed("goodsManagement")
    @Override
    public List<Good> getAllGoods() {
        return goodsDao.findAll();
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void removeGood(Good id) {
        goodsDao.delete(id);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public Long add(Good good) {
        goodsDao.save(good);
        return good.getId();
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void edit(Good good) {
        goodsDao.save(good);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public Good findById(Long goodId) {
        return goodsDao.findOne(goodId);
    }

    @Override
    public Page<Good> search(String searchQuery, PageRequest pageRequest) {
        return goodsDao.search(searchQuery, pageRequest);
    }

}
