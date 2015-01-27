package pl.lodz.p.project.core.jsf.base;

import org.apache.commons.lang3.StringUtils;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Sort;

import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
public abstract class EditPageableListController<T extends Serializable> extends EditListController<T> {

	private static final long serialVersionUID = 1L;

	private Page<T> page;
	private PageRequest pageRequest;
	private String searchQuery = StringUtils.EMPTY;

	public void search() {
		pageRequest = new PageRequest(0, pageRequest.getPageSize(), pageRequest.getSort());
		page = getService().search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void nextPage() {
		pageRequest = new PageRequest(pageRequest.getPageNumber() + 1, pageRequest.getPageSize(), pageRequest.getSort());
		page = getService().search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void prevPage() {
		pageRequest = new PageRequest(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(), pageRequest.getSort());
		page = getService().search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void goToPage(int number) {
		pageRequest = new PageRequest(number, pageRequest.getPageSize(), pageRequest.getSort());
		page = getService().search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void initStartPage(Integer pageSize, String sortBy) {
		pageRequest = new PageRequest(0, pageSize, new Sort(sortBy));
	}

	public void remove(T object) {
		getItems().remove(object);
		getService().disactive(object);
	}

	public Page<T> getPage() {
		return page;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

}
