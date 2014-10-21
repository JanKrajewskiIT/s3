package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.goods.Good;
import pl.lodz.p.was04.department.core.dto.goods.GoodDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.goods.GoodsGroupsManagerLocal;
import pl.lodz.p.was04.department.core.manager.goods.GoodsManagerLocal;
import pl.lodz.p.was04.department.core.manager.goods.TaxesManagerLocal;
import pl.lodz.p.was04.department.core.manager.goods.UnitsManagerLocal;

/**
 *
 * @author Łukasz
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class GoodsManagementEndpoint implements GoodsManagementEndpointLocal {

    @Autowired
    GoodsManagerLocal goodsManagerLocal;

    @Autowired
    UnitsManagerLocal unitsManagerLocal;

    @Autowired
    GoodsGroupsManagerLocal goodsGroupsManagerLocal;

    @Autowired
    TaxesManagerLocal taxesManagerLocal;

    @RolesAllowed("goodsManagement")
    @Override
    public List<GoodDTO> getAllGoods() {
        return createGoodsDTOList(goodsManagerLocal.getAllGoods());
    }

    private List<GoodDTO> createGoodsDTOList(List<Good> listOfEnties) {
        List<GoodDTO> list = new ArrayList<>();
        for (int i = 0; i < listOfEnties.size(); i++) {
            list.add(new GoodDTO(listOfEnties.get(i)));
        }
        return list;
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void removeGood(GoodDTO goodDTO) {
        goodsManagerLocal.removeGood(new Good(goodDTO));
    }

    @RolesAllowed("goodsManagement")
    @Override
    public Long add(GoodDTO goodDTO) {
        Good good = new Good(goodDTO);
        return goodsManagerLocal.add(good);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void edit(GoodDTO goodDTO) {
        Good good = new Good(goodDTO);
        goodsManagerLocal.edit(good);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public GoodDTO findById(Long id) {
        return new GoodDTO(goodsManagerLocal.findById(id));
    }

    @Override
    public Page<GoodDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Good> pageGoods = goodsManagerLocal.search(searchQuery, pageRequest);
        List<GoodDTO> goodDTOs = createGoodsDTOList(pageGoods.getContent());
        return new PageImpl<>(goodDTOs, pageRequest, pageGoods.getTotalElements());
    }

}
