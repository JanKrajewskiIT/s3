package pl.lodz.p.project.core.service.good;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.dao.good.GoodDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodDao goodDao;
    
    @Autowired
    GoodConverter goodConverter;

    @RolesAllowed("goodsManagement")
    @Override
    public List<GoodDTO> getAllGoods() {
        List<GoodDTO> goodList = new ArrayList<>();
        for (Good good : goodDao.findAll()) {
        	GoodDTO goodDTO = goodConverter.convertEntity(good);
        	goodList.add(goodDTO);
        }
        return goodList;
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void removeGood(GoodDTO goodDTO) {
    	Good good = goodConverter.convertDTO(goodDTO);
        goodDao.delete(good);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public Long add(GoodDTO goodDTO) {
        Good good = goodConverter.convertDTO(goodDTO);
        goodDao.save(good);
        return good.getId();
    }

    @RolesAllowed("goodsManagement")
    @Override
    public void edit(GoodDTO goodDTO) {
        Good good = goodConverter.convertDTO(goodDTO);
        goodDao.save(good);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public GoodDTO findById(Long id) {
        Good good = goodDao.findOne(id);
        return goodConverter.convertEntity(good);
    }

    @Override
    public Page<GoodDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Good> pageGoods = goodDao.search(searchQuery, pageRequest);
        List<GoodDTO> goodList = new ArrayList<>();
        for (Good good : pageGoods.getContent()) {
        	GoodDTO goodDTO = goodConverter.convertEntity(good);
        	goodList.add(goodDTO);
        }
        return new PageImpl<>(goodList, pageRequest, pageGoods.getTotalElements());
    }

}
