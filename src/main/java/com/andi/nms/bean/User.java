package com.andi.nms.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 关联数据ID
     */
    @Column(name = "rel_id")
    private Integer relId;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return pass_word
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取用户类型
     *
     * @return type - 用户类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置用户类型
     *
     * @param type 用户类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取关联数据ID
     *
     * @return rel_id - 关联数据ID
     */
    public Integer getRelId() {
        return relId;
    }

    /**
     * 设置关联数据ID
     *
     * @param relId 关联数据ID
     */
    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", type=" + type +
                ", relId=" + relId +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                '}';
    }
}