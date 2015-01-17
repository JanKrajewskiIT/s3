package pl.lodz.p.project.core.jsf.base;

import com.google.common.collect.Lists;
import pl.lodz.p.project.core.service.base.AbstractService;
import pl.lodz.p.project.core.service.base.ServiceRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class EditObjectController<T extends Serializable> extends UIObject implements Serializable {

	private static final long serialVersionUID = -5022126225567406058L;

	private ServiceRepository service;

	protected T sourceObject;
	protected Mode mode = Mode.EDIT;

	public static enum Mode {
		EDIT, CREATE
	}

	private Action SAVE_ACTION = new Action("Zapisz", "") {

		@Override
		public void call() {
			save();
		}

	};

	private Action CLEAN_ACTION = new Action("Wyczyść", "") {

		@Override
		public void call() {
			sourceObject = (T) new Object();
		}

	};

	public abstract void save();

	public List<Action> getActions() {
		return Lists.newArrayList(SAVE_ACTION, CLEAN_ACTION);
	}

	public T getSourceObject() {
		return sourceObject;
	}

	public void setSourceObject(T sourceObject) {
		this.sourceObject = sourceObject;
	}

	public void setService(ServiceRepository service) {
		this.service = service;
	}

}
