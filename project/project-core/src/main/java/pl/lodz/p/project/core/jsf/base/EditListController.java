package pl.lodz.p.project.core.jsf.base;

import pl.lodz.p.project.core.dto.contractor.ContractorDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class EditListController<T extends Serializable> extends UIObject implements Serializable {

	private static final long serialVersionUID = 5723219866142777750L;
	
	protected List<T> items = new ArrayList<T>();
	protected List<T> selection = new ArrayList<T>();
	protected T singleSelection;

	public void remove(T object) { }

	public void edit(Long id) { }

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
}
