package com.andi.nms.business.bean;

import javax.persistence.*;

@Table(name = "t_user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user;

    private Integer entity;

    private Integer authority;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user
     */
    public Integer getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(Integer user) {
        this.user = user;
    }

    /**
     * @return entity
     */
    public Integer getEntity() {
        return entity;
    }

    /**
     * @param entity
     */
    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    /**
     * @return authority
     */
    public Integer getAuthority() {
        return authority;
    }

    /**
     * @param authority
     */
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}