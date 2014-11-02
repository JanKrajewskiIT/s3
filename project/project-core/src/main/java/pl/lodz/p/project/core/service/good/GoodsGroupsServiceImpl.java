package pl.lodz.p.project.core.service.good;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.good.GoodGroupConverter;
import pl.lodz.p.project.core.dao.good.GoodGroupDao;
import pl.lodz.p.project.core.domain.good.GoodGroup;
import pl.lodz.p.project.core.dto.good.GoodGroupDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class GoodsGroupsServiceImpl implements GoodsGroupsService {

    @Autowired
    GoodGroupDao goodGroupDao;
    
    @Autowired
    GoodGroupConverter goodGroupConverter;

    @RolesAllowed("goodsGroupManagement")
    @Override
    public List<GoodGroupDTO> getGoodsGroups() {
    	Transformer<GoodGroup, GoodGroupDTO> transformer = new Transformer<>(goodGroupConverter);
    	return Lists.transform(goodGroupDao.findAll(), transformer);
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public GoodGroupDTO getGroup(Long id) {
        GoodGroup goodGroup = goodGroupDao.findOne(id);
        return goodGroupConverter.convertEntity(goodGroup);
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public Long add(GoodGroupDTO goodGroupDTO) {
        GoodGroup goodGroup = goodGroupConverter.convertDTO(goodGroupDTO);
        goodGroupDao.save(goodGroup);
        return goodGroup.getId();
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public void edit(GoodGroupDTO goodGroupDTO) {
        GoodGroup goodGroup = goodGroupConverter.convertDTO(goodGroupDTO);
        goodGroupDao.save(goodGroup);
    }

    @RolesAllowed("goodsGroupManagement")
    @Override
    public void remove(GoodGroupDTO goodGroupDTO) {
        GoodGroup goodGroup = goodGroupConverter.convertDTO(goodGroupDTO);
        goodGroupDao.delete(goodGroup);
    }
    
}
