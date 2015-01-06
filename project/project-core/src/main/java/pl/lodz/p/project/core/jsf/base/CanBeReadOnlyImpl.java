package pl.lodz.p.project.core.jsf.base;

/**
 * @author Jan Krajewski
 */
public class CanBeReadOnlyImpl implements CanBeReadOnly {

	private boolean readOnly = false;
	
	@Override
	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
}
