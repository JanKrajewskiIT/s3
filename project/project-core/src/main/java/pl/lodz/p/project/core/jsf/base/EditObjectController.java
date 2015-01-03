package pl.lodz.p.project.core.jsf.base;

import java.io.Serializable;

public abstract class EditObjectController<T extends Serializable> extends CanBeReadOnlyImpl implements Serializable {

	private static final long serialVersionUID = -5022126225567406058L;

	public static enum Mode {
		EDIT, CREATE
	}

	protected T sourceObject;
	protected T currentObject;
	protected Mode mode = Mode.EDIT;
	
}
