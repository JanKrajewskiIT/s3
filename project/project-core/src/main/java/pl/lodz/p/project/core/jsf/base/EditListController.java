package pl.lodz.p.project.core.jsf.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public abstract class EditListController<T extends Serializable> extends CanBeReadOnlyImpl implements Serializable {

	private static final long serialVersionUID = 5723219866142777750L;
	
	protected Collection<T> items = new ArrayList<T>();
	protected Collection<T> selection = new ArrayList<T>();

}
