package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;
import pl.lodz.p.was04.department.core.domain.goods.GoodGroup;

/**
 *
 * @author Łukasz, milczu
 *
 */
public interface GoodsGroupsManagerLocal {

    GoodGroup getById(Long goodId);

    List<GoodGroup> getGoodsGroups();
    
    Long add(GoodGroup goodGroup);
    
    void edit(GoodGroup goodGroup);
    
    void remove(GoodGroup goodGroup);
}
