package pl.lodz.p.project.core.domain.base;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.springframework.data.domain.Persistable;

/**
 * 
 * @author Jan Krajewski
 *
 * @param <T>
 */
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements Persistable<T>, Comparable<BaseEntity<T>> {

	private static final long serialVersionUID = -1680671235262469028L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private T id;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
	private boolean active = true;
	
	@Version
	private Long version = 1L;	
	
	@Override
	public T getId() {
		return id;
	}	
	
	public void setId(T id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		return id == null;
	}	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int compareTo(BaseEntity<T> o) {
		//TODO implement comparator
		return -1;
	}

}
