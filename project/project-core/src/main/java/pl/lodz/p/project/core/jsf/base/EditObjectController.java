package pl.lodz.p.project.core.jsf.base;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Persistable;
import pl.lodz.p.project.core.service.base.ServiceRepository;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class EditObjectController<T extends Serializable> extends UIObject implements Serializable {

	private static final long serialVersionUID = 1L;

	protected T sourceObject;
	protected Mode mode = Mode.EDIT;

	private Action SAVE_ACTION = new Action("Zapisz", "") {

		@Override
		public void call() {
			 save();
		}

	};

	private Action CLEAN_ACTION = new Action("Wyczyść", "@form") {

		@Override
		public void call() {
			createNew();
		}

	};

	@PostConstruct
	protected void init() {
		String id = GUI.catchId("id");
		if (StringUtils.isBlank(id)) {
			createNew();
		} else {
			Long longId = Long.parseLong(id);
			sourceObject = getService().getOneById(longId);
		}
	}

	protected abstract void createNew();

	protected void save() {
		getService().save(sourceObject);
	}

	public List<Action> getActions() {
		return Lists.newArrayList(SAVE_ACTION, CLEAN_ACTION);
	}

	public T getSourceObject() {
		return sourceObject;
	}

	public void setSourceObject(T sourceObject) {
		this.sourceObject = sourceObject;
	}

	public abstract ServiceRepository<Persistable<Long>, T> getService();

}
