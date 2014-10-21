/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import pl.lodz.p.was04.department.core.domain.PendingInvitation;

/**
 *
 * @author Łukasz Gadomski
 */
public class PendingInvitationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long invitationId;
    private String email;
    private String token;
    private Date creationDate;
    private RoleDTO roleDTO;

    public PendingInvitationDTO(PendingInvitation pendingInvitation) {
        this.invitationId = pendingInvitation.getId();
        this.email = pendingInvitation.getEmail();
        this.token = pendingInvitation.getToken();
        this.creationDate = pendingInvitation.getCreationDate();
        this.roleDTO = new RoleDTO(pendingInvitation.getRole());
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.invitationId);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.token);
        hash = 89 * hash + Objects.hashCode(this.creationDate);
        hash = 89 * hash + Objects.hashCode(this.roleDTO);
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
        final PendingInvitationDTO other = (PendingInvitationDTO) obj;
        if (!Objects.equals(this.invitationId, other.invitationId)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        if (!Objects.equals(this.creationDate, other.creationDate)) {
            return false;
        }
        if (!Objects.equals(this.roleDTO, other.roleDTO)) {
            return false;
        }
        return true;
    }

}
