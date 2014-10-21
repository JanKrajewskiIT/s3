/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.dto.goods;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.domain.goods.GoodGroup;

/**
 *
 * @author Łukasz
 */
public class GoodGroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private boolean active = true;
    private Long version = 1L;

    public GoodGroupDTO() {
    }

    public GoodGroupDTO(Long id) {
        this.id = id;
    }

    public GoodGroupDTO(GoodGroup goodsGroups) {
        this.id = goodsGroups.getId();
        this.name = goodsGroups.getName();
        this.active = goodsGroups.isActive();
        this.version = goodsGroups.getVersion();
    }

    public GoodGroupDTO(GoodGroupDTO goodsGroups) {
        this.id = goodsGroups.getId();
        this.name = goodsGroups.getName();
        this.active = goodsGroups.isActive();
        this.version = goodsGroups.getVersion();
    }

    public GoodGroupDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param isActive the active to set
     */
    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
