package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.goods.GoodGroup;
import pl.lodz.p.was04.department.core.dto.goods.GoodGroupDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.goods.GoodsGroupsManagerLocal;

/**
 *
 * @author Łukasz
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class GoodsGroupsManagementEndpoint implements GoodsGroupsManagementEndpointLocal {

    @Autowired
    GoodsGroupsManagerLocal goodsGroupsManagerLocal;

    @RolesAllowed("goodsGroupManagement")
    @Override
    public List<GoodGroupDTO> getGoodsGroups() {
        return createGoodsGroupsDTOList(goodsGroupsManagerLocal.getGoodsGroups());
    }

    private List<GoodGroupDTO> createGoodsGroupsDTOList(List<GoodGroup> listOfEnties) {
        List<GoodGroupDTO> goodsGroupsDTO = new ArrayList<>();
        for (int i = 0; i < listOfEnties.size(); i++) {
            goodsGroupsDTO.add(new GoodGroupDTO(listOfEnties.get(i)));
        }
        return goodsGroupsDTO;
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public GoodGroupDTO getGroup(Long id) {
        return new GoodGroupDTO(goodsGroupsManagerLocal.getById(id));
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public Long add(GoodGroupDTO goodGroupDTO) {
        return goodsGroupsManagerLocal.add(new GoodGroup(goodGroupDTO));
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public void edit(GoodGroupDTO goodGroupDTO) {
        goodsGroupsManagerLocal.edit(new GoodGroup(goodGroupDTO));
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public void remove(GoodGroupDTO goodGroupDTO) {
        goodsGroupsManagerLocal.remove(new GoodGroup(goodGroupDTO));
    }
}
