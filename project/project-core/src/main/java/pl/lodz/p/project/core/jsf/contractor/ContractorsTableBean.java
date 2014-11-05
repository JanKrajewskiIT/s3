package pl.lodz.p.project.core.jsf.contractor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Sort;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.service.contractor.ContractorService;

/**
 *
 * @author Janiu
 */
@Named(value = "contractorsTableBean")
@Scope("request")
public class ContractorsTableBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE = 5;
    private static final String DEFAULT_SORT_PROPERTY = "name";

    @Autowired
    private ContractorService contractorsManagementEndpointLocal;

    private Page<ContractorDTO> page;
    private PageRequest pageRequest = new PageRequest(0, PAGE_SIZE, new Sort(DEFAULT_SORT_PROPERTY));
    private String searchQuery = StringUtils.EMPTY;

    public ContractorsTableBean() {
    }

    @PostConstruct
    public void init() {
        //setContractorsList(contractorsManagementEndpointLocal.getAllContractors());
        //Collections.sort(getContractorsList());
        page = contractorsManagementEndpointLocal.search(searchQuery, pageRequest);
    }

    public String editContractor(String id) {
        return "addEditContractor.xhtml?faces-redirect=true&id=" + id;
    }

    public void removeContractor(ContractorDTO contractor) {
        getContractorsList().remove(contractor);
        contractorsManagementEndpointLocal.delete(contractor.getId());
    }

    public List<ContractorDTO> getContractorsList() {
        return page.getContent();
    }

    public Page<ContractorDTO> getPage() {
        return page;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public void search() {
        System.out.println("Search: " + searchQuery);
        pageRequest = new PageRequest(0, pageRequest.getPageSize(), pageRequest.getSort());
        page = contractorsManagementEndpointLocal.search(searchQuery, pageRequest);
    }

    public void nextPage() {
        pageRequest = new PageRequest(pageRequest.getPageNumber() + 1, pageRequest.getPageSize(), pageRequest.getSort());
        page = contractorsManagementEndpointLocal.search(searchQuery, pageRequest);
    }

    public void prevPage() {
        pageRequest = new PageRequest(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(), pageRequest.getSort());
        page = contractorsManagementEndpointLocal.search(searchQuery, pageRequest);
    }

    /**
     *
     * @param number zero indexed number of page
     */
    public void goToPage(int number) {
        pageRequest = new PageRequest(number, pageRequest.getPageSize(), pageRequest.getSort());
        page = contractorsManagementEndpointLocal.search(searchQuery, pageRequest);
    }
}
