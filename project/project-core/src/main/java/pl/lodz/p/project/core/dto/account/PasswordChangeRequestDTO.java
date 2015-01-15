package pl.lodz.p.project.core.dto.account;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.BaseDTO;

import java.util.Date;

/**
 *
 * @author Łukasz Gadomski, Janiu
 */
public class PasswordChangeRequestDTO extends BaseDTO<Long> implements Comparable<PasswordChangeRequestDTO> {

	private static final long serialVersionUID = 1L;

    private Date creationDate;
    private UserDTO user;

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
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
