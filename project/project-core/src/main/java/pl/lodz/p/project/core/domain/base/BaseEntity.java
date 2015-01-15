package pl.lodz.p.project.core.domain.base;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Versioned, Persistable<ID>, Activable, Comparable<BaseEntity<ID>> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ID id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
	private boolean active = true;

	@Version
	private Long version = 1L;

	@Override
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		return id == null;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int compareTo(BaseEntity<ID> o) {
		return -1;
	}

}
