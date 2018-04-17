package com.andi.nms.business.bean;

import javax.persistence.*;

@Table(name = "t_role")
public class Role {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    private String name;

    /**
     * 1：Administrator，2：Operator，3：SVNO
     */
    private Integer type;

    @Column(name = "ncs_id")
    private String ncsId;

    private String description;

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取1：Administrator，2：Operator，3：SVNO
     *
     * @return type - 1：Administrator，2：Operator，3：SVNO
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1：Administrator，2：Operator，3：SVNO
     *
     * @param type 1：Administrator，2：Operator，3：SVNO
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return ncs_id
     */
    public String getNcsId() {
        return ncsId;
    }

    /**
     * @param ncsId
     */
    public void setNcsId(String ncsId) {
        this.ncsId = ncsId;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}