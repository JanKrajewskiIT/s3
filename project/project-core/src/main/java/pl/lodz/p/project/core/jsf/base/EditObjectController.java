package pl.lodz.p.project.core.jsf.base;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Persistable;
import pl.lodz.p.project.core.service.base.ServiceRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class EditObjectController<T extends Serializable> extends UIObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private ServiceRepository<Persistable<Long>, T> service;
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

	private Action CLEAN_ACTION = new Action("Wyczyść", "@form") {

		@Override
		public void call() { createNew(); }

	};

	protected void setObject() {
		String id = GUI.catchId("id");
		if (StringUtils.isBlank(id)) {
			createNew();
		} else {
			Long longId = Long.parseLong(id);
			sourceObject = service.getOneById(longId);
		}
	}

	protected /*abstract*/ void createNew() { }

	protected abstract void save();

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
