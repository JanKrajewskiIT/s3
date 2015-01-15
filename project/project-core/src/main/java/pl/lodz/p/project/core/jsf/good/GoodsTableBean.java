package pl.lodz.p.project.core.jsf.good;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Sort;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.service.good.GoodService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Łukasz
 */
@Named(value = "goodsTableBean")
@Scope("request")
public class GoodsTableBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int PAGE_SIZE = 5;
    private static final String DEFAULT_SORT_PROPERTY = "name";
    
    @Autowired
    private GoodService goodsManagementEndpointLocal;

    private Page<GoodDTO> page;
    private PageRequest pageRequest = new PageRequest(0, PAGE_SIZE, new Sort(DEFAULT_SORT_PROPERTY));
    private String searchQuery = StringUtils.EMPTY;

    /**
     * Creates a new instance of GoodsTable
     */
    public GoodsTableBean() {
    }

    @PostConstruct
    public void init() {
        page = goodsManagementEndpointLocal.search(searchQuery, pageRequest);
    }

    public void removeGood(GoodDTO good) {
        getGoodsList().remove(good);
        goodsManagementEndpointLocal.delete(good);
    }

    /**
     * @return the goodsList
     */
    public List<GoodDTO> getGoodsList() {
        return page.getContent();
    }

    public Page<GoodDTO> getPage() {
        return page;
    }

    public String getSearchQuery() {
        return searchQuery;
    }
    
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
    
    public void search() {
        System.out.println("Search: "  + searchQuery);
        pageRequest = new PageRequest(0, pageRequest.getPageSize(), pageRequest.getSort());
        page = goodsManagementEndpointLocal.search(searchQuery, pageRequest);
    }
    
    public void nextPage() {
        pageRequest = new PageRequest(pageRequest.getPageNumber()+1, pageRequest.getPageSize(), pageRequest.getSort());
        page = goodsManagementEndpointLocal.search(searchQuery, pageRequest);
    }
    
    public void prevPage() {
        pageRequest = new PageRequest(pageRequest.getPageNumber()-1, pageRequest.getPageSize(), pageRequest.getSort());
        page = goodsManagementEndpointLocal.search(searchQuery, pageRequest);
    }
    
    /**
     * 
     * @param number zero indexed number of page
     */
    public void goToPage(int number) {
        pageRequest = new PageRequest(number, pageRequest.getPageSize(), pageRequest.getSort());
        page = goodsManagementEndpointLocal.search(searchQuery, pageRequest);
    }
    
}
