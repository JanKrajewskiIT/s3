/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.project.core.dto.account;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.domain.account.Role;

import com.google.common.collect.ComparisonChain;

/**
 * DTO class mapping entities of type {@link Role}
 *
 * @author Łukasz Gadomski, Janiu
 */
public class RoleDTO implements Serializable, Comparable<RoleDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(RoleDTO o) {
		return ComparisonChain.start().compare(this.id, o.getId()).result();
	}
	
}
