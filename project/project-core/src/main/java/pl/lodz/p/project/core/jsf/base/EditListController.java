package pl.lodz.p.project.core.jsf.base;

import org.apache.commons.lang3.StringUtils;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dao.pagingandsearching.Sort;
import pl.lodz.p.project.core.domain.base.BaseEntity;
import pl.lodz.p.project.core.dto.base.BaseDTO;
import pl.lodz.p.project.core.service.base.AbstractService;
import pl.lodz.p.project.core.service.base.ServiceRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class EditListController<T extends Serializable> extends UIObject implements Serializable {

	private static final long serialVersionUID = 1L;

	protected List<T> items = new ArrayList<T>();
	protected List<T> selection = new ArrayList<T>();
	protected T singleSelection;

	private ServiceRepository service;
	private Page<T> page;
	private PageRequest pageRequest;
	private String searchQuery = StringUtils.EMPTY;

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

	public void goToPage(int number) {
		pageRequest = new PageRequest(number, pageRequest.getPageSize(), pageRequest.getSort());
		page = service.search(searchQuery, pageRequest);
		setItems(page.getContent());
	}

	public void initStartPage(Integer pageSize, String sortBy) {
		pageRequest = new PageRequest(0, pageSize, new Sort(sortBy));
	}

	public void remove(T object) {
		getItems().remove(object);
		service.delete(object);
	}

	public String edit(String id) {
		return null;
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

	public ServiceRepository getService() {
		return service;
	}

	public void setService(ServiceRepository service) {
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
