package pl.lodz.p.project.core.dto.account;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.ComparisonChain;

/**
 *
 * @author Łukasz Gadomski, Janiu
 */
public class PasswordChangeRequestDTO implements Serializable, Comparable<PasswordChangeRequestDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private Date creationDate;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(PasswordChangeRequestDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}

}
