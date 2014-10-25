package pl.lodz.p.was04.department.core.jsf.goods;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.goods.GoodGroupDTO;
import pl.lodz.p.was04.department.core.endpoint.goods.GoodsGroupsManagementEndpointLocal;

/**
 *
 * @author Łukasz
 */
@Named(value = "goodsGroupsBean")
@Scope("request")
public class GoodsGroupsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private GoodsGroupsManagementEndpointLocal goodsGroupsManagementEndpointLocal;

    private List<GoodGroupDTO> goodsGroupsList;

    /**
     * Creates a new instance of Units
     */
    public GoodsGroupsBean() {
    }

    @PostConstruct
    public void init() {
        setGoodsGroupsList(goodsGroupsManagementEndpointLocal.getGoodsGroups());
    }

    /**
     * @return the goodsGroupsList
     */
    public List<GoodGroupDTO> getGoodsGroupsList() {
        return goodsGroupsList;
    }

    /**
     * @param goodsGroupsList the goodsGroupsList to set
     */
    public void setGoodsGroupsList(List<GoodGroupDTO> goodsGroupsList) {
        this.goodsGroupsList = goodsGroupsList;
    }

    

}
