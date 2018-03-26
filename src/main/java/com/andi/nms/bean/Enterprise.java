package com.andi.nms.bean;

import java.util.Date;
import javax.persistence.*;

public class Enterprise {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 企业名称
     */
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 联系人
     */
    @Column(name = "enterprise_contacts")
    private String enterpriseContacts;

    /**
     * 联系人电话
     */
    @Column(name = "enterprise_phone")
    private String enterprisePhone;

    /**
     * 企业邮箱
     */
    @Column(name = "enterprise_email")
    private String enterpriseEmail;

    /**
     * 企业规模
     */
    @Column(name = "enterprise_scale")
    private Integer enterpriseScale;

    /**
     * 企业性质
     */
    @Column(name = "enterprise_type")
    private Integer enterpriseType;

    /**
     * 企业图标地址
     */
    @Column(name = "enterprise_icon")
    private String enterpriseIcon;

    /**
     * 企业介绍
     */
    @Column(name = "enterprise_remark")
    private String enterpriseRemark;

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
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取企业名称
     *
     * @return enterprise_name - 企业名称
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置企业名称
     *
     * @param enterpriseName 企业名称
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取联系人
     *
     * @return enterprise_contacts - 联系人
     */
    public String getEnterpriseContacts() {
        return enterpriseContacts;
    }

    /**
     * 设置联系人
     *
     * @param enterpriseContacts 联系人
     */
    public void setEnterpriseContacts(String enterpriseContacts) {
        this.enterpriseContacts = enterpriseContacts;
    }

    /**
     * 获取联系人电话
     *
     * @return enterprise_phone - 联系人电话
     */
    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    /**
     * 设置联系人电话
     *
     * @param enterprisePhone 联系人电话
     */
    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    /**
     * 获取企业邮箱
     *
     * @return enterprise_email - 企业邮箱
     */
    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    /**
     * 设置企业邮箱
     *
     * @param enterpriseEmail 企业邮箱
     */
    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    /**
     * 获取企业规模
     *
     * @return enterprise_scale - 企业规模
     */
    public Integer getEnterpriseScale() {
        return enterpriseScale;
    }

    /**
     * 设置企业规模
     *
     * @param enterpriseScale 企业规模
     */
    public void setEnterpriseScale(Integer enterpriseScale) {
        this.enterpriseScale = enterpriseScale;
    }

    /**
     * 获取企业性质
     *
     * @return enterprise_type - 企业性质
     */
    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * 设置企业性质
     *
     * @param enterpriseType 企业性质
     */
    public void setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    /**
     * 获取企业图标地址
     *
     * @return enterprise_icon - 企业图标地址
     */
    public String getEnterpriseIcon() {
        return enterpriseIcon;
    }

    /**
     * 设置企业图标地址
     *
     * @param enterpriseIcon 企业图标地址
     */
    public void setEnterpriseIcon(String enterpriseIcon) {
        this.enterpriseIcon = enterpriseIcon;
    }

    /**
     * 获取企业介绍
     *
     * @return enterprise_remark - 企业介绍
     */
    public String getEnterpriseRemark() {
        return enterpriseRemark;
    }

    /**
     * 设置企业介绍
     *
     * @param enterpriseRemark 企业介绍
     */
    public void setEnterpriseRemark(String enterpriseRemark) {
        this.enterpriseRemark = enterpriseRemark;
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
}