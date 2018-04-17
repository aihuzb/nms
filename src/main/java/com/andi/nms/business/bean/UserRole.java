package com.andi.nms.business.bean;

import javax.persistence.*;

@Table(name = "t_user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer role;

    private Integer user;

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
     * @return role
     */
    public Integer getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(Integer role) {
        this.role = role;
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
}