package pl.lodz.p.project.core.service.good;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.dao.good.GoodDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class GoodServiceImpl extends AbstractService<Good, GoodDTO> implements GoodService {

	private final static String ACCESS_LEVEL = "goodsManagement";
	
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<GoodDTO> getAll() {
    	return super.getAll();
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public GoodDTO getOneById(Long id) {
    	return super.getOneById(id);
    }
    
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void delete(GoodDTO goodDTO) {
    	super.delete(goodDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public void save(GoodDTO goodDTO) {
    	super.save(goodDTO);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<GoodDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Good> pageGoods = ((GoodDao) dao).search(searchQuery, pageRequest);
    	List<GoodDTO> goodList = Lists.transform(pageGoods.getContent(), transformer);
        return new PageImpl<>(goodList, pageRequest, pageGoods.getTotalElements());
    }

}
