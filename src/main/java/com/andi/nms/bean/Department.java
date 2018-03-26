package com.andi.nms.bean;

import java.util.Date;
import javax.persistence.*;

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_scale")
    private Integer departmentScale;

    /**
     * 联系人
     */
    @Column(name = "department_contacts")
    private String departmentContacts;

    /**
     * 联系人电话
     */
    @Column(name = "department_phone")
    private String departmentPhone;

    /**
     * 企业邮箱
     */
    @Column(name = "department_email")
    private String departmentEmail;

    @Column(name = "department_remark")
    private String departmentRemark;

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
     * @return department_name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return department_scale
     */
    public Integer getDepartmentScale() {
        return departmentScale;
    }

    /**
     * @param departmentScale
     */
    public void setDepartmentScale(Integer departmentScale) {
        this.departmentScale = departmentScale;
    }

    /**
     * 获取联系人
     *
     * @return department_contacts - 联系人
     */
    public String getDepartmentContacts() {
        return departmentContacts;
    }

    /**
     * 设置联系人
     *
     * @param departmentContacts 联系人
     */
    public void setDepartmentContacts(String departmentContacts) {
        this.departmentContacts = departmentContacts;
    }

    /**
     * 获取联系人电话
     *
     * @return department_phone - 联系人电话
     */
    public String getDepartmentPhone() {
        return departmentPhone;
    }

    /**
     * 设置联系人电话
     *
     * @param departmentPhone 联系人电话
     */
    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    /**
     * 获取企业邮箱
     *
     * @return department_email - 企业邮箱
     */
    public String getDepartmentEmail() {
        return departmentEmail;
    }

    /**
     * 设置企业邮箱
     *
     * @param departmentEmail 企业邮箱
     */
    public void setDepartmentEmail(String departmentEmail) {
        this.departmentEmail = departmentEmail;
    }

    /**
     * @return department_remark
     */
    public String getDepartmentRemark() {
        return departmentRemark;
    }

    /**
     * @param departmentRemark
     */
    public void setDepartmentRemark(String departmentRemark) {
        this.departmentRemark = departmentRemark;
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