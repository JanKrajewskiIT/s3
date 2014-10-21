/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.dto;

import java.util.Date;

import pl.lodz.p.was04.department.core.domain.PasswordChangeRequest;

/**
 *
 * @author Łukasz Gadomski
 */
public class PasswordChangeRequestDTO {

    private String id;
    private Date creationDate;
    private UserDTO userDTO;

    public PasswordChangeRequestDTO(PasswordChangeRequest passwordChangeRequest) {
        this.id = passwordChangeRequest.getId();
        this.creationDate = passwordChangeRequest.getCreationDate();
        this.userDTO = new UserDTO(passwordChangeRequest.getUser());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
