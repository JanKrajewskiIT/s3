/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.dto;

import java.io.Serializable;
import java.util.Objects;

import pl.lodz.p.was04.department.core.domain.Role;

/**
 * DTO class mapping entities of type {@link Role}
 *
 * @author Łukasz Gadomski
 */
public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String roleName;

    public RoleDTO(Role role) {
        this.roleName = role.getRoleName();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.roleName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleDTO other = (RoleDTO) obj;
        if (!Objects.equals(this.roleName, other.roleName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RoleDTO{" + "roleName=" + roleName + '}';
    }

}
