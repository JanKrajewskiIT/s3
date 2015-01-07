package pl.lodz.p.project.core.jsf.base;

/**
 * @author Jan Krajewski
 */
public class UIObject implements CanBeReadOnly, CanBeVisible {

	private boolean readOnly = false;
	private boolean visible = true;
	
	@Override
	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
