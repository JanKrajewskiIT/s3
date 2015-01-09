package pl.lodz.p.project.core.jsf.base;

import org.apache.commons.lang3.StringUtils;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Sort;
import pl.lodz.p.project.core.service.AbstractService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class EditListController<T extends Serializable> extends UIObject implements Serializable {

	private static final long serialVersionUID = 5723219866142777750L;
	private static final int PAGE_SIZE = 5;
	private static final String DEFAULT_SORT_PROPERTY = "name";

	protected List<T> items = new ArrayList<T>();
	protected List<T> selection = new ArrayList<T>();
	protected T singleSelection;
	private AbstractService service;

	protected Page<T> page;
	protected PageRequest pageRequest = new PageRequest(0, PAGE_SIZE, new Sort(DEFAULT_SORT_PROPERTY));
	protected String searchQuery = StringUtils.EMPTY;

	public void remove(T object) { }

	public void edit(Long id) { }

	public void search() {
		pageRequest = new PageRequest(0, pageRequest.getPageSize(), pageRequest.getSort());
		page = service.search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void nextPage() {
		pageRequest = new PageRequest(pageRequest.getPageNumber() + 1, pageRequest.getPageSize(), pageRequest.getSort());
		page = service.search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void prevPage() {
		pageRequest = new PageRequest(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(), pageRequest.getSort());
		page = service.search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	/**
	 *
	 * @param number zero indexed number of page
	 */
	public void goToPage(int number) {
		pageRequest = new PageRequest(number, pageRequest.getPageSize(), pageRequest.getSort());
		page = service.search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void onSelect(T selected) {
		setSingleSelection(selected);
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public List<T> getSelection() {
		return selection;
	}

	public void setSelection(List<T> selection) {
		this.selection = selection;
	}

	public T getSingleSelection() {
		return singleSelection;
	}

	public void setSingleSelection(T singleSelection) {
		this.singleSelection = singleSelection;
	}

	public AbstractService getService() {
		return service;
	}

	public void setService(AbstractService service) {
		this.service = service;
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
