package com.andi.nms.bean;

import java.util.Date;
import javax.persistence.*;

public class Staff {
    /**
     * 员工ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工姓名
     */
    @Column(name = "staff_name")
    private String staffName;

    /**
     * 员工年龄
     */
    @Column(name = "staff_age")
    private Integer staffAge;

    /**
     * 性别 1：男，2：女
     */
    @Column(name = "staff_sex")
    private Integer staffSex;

    /**
     * 出生年月
     */
    @Column(name = "staff_bron")
    private Date staffBron;

    /**
     * 电话号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    @Column(name = "staff_email")
    private String staffEmail;

    /**
     * 居住地址
     */
    @Column(name = "staff_address")
    private String staffAddress;

    /**
     * 所属企业ID
     */
    @Column(name = "companyId_id")
    private Integer companyidId;

    /**
     * 工龄
     */
    @Column(name = "staff_seniority")
    private Double staffSeniority;

    /**
     * 家庭情况
     */
    @Column(name = "staff_homeInfo")
    private String staffHomeinfo;

    /**
     * 头像连接
     */
    @Column(name = "staff_icon")
    private String staffIcon;

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
     * 获取员工ID
     *
     * @return id - 员工ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置员工ID
     *
     * @param id 员工ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工姓名
     *
     * @return staff_name - 员工姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置员工姓名
     *
     * @param staffName 员工姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取员工年龄
     *
     * @return staff_age - 员工年龄
     */
    public Integer getStaffAge() {
        return staffAge;
    }

    /**
     * 设置员工年龄
     *
     * @param staffAge 员工年龄
     */
    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    /**
     * 获取性别 1：男，2：女
     *
     * @return staff_sex - 性别 1：男，2：女
     */
    public Integer getStaffSex() {
        return staffSex;
    }

    /**
     * 设置性别 1：男，2：女
     *
     * @param staffSex 性别 1：男，2：女
     */
    public void setStaffSex(Integer staffSex) {
        this.staffSex = staffSex;
    }

    /**
     * 获取出生年月
     *
     * @return staff_bron - 出生年月
     */
    public Date getStaffBron() {
        return staffBron;
    }

    /**
     * 设置出生年月
     *
     * @param staffBron 出生年月
     */
    public void setStaffBron(Date staffBron) {
        this.staffBron = staffBron;
    }

    /**
     * 获取电话号码
     *
     * @return phone_number - 电话号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置电话号码
     *
     * @param phoneNumber 电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取邮箱
     *
     * @return staff_email - 邮箱
     */
    public String getStaffEmail() {
        return staffEmail;
    }

    /**
     * 设置邮箱
     *
     * @param staffEmail 邮箱
     */
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    /**
     * 获取居住地址
     *
     * @return staff_address - 居住地址
     */
    public String getStaffAddress() {
        return staffAddress;
    }

    /**
     * 设置居住地址
     *
     * @param staffAddress 居住地址
     */
    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    /**
     * 获取所属企业ID
     *
     * @return companyId_id - 所属企业ID
     */
    public Integer getCompanyidId() {
        return companyidId;
    }

    /**
     * 设置所属企业ID
     *
     * @param companyidId 所属企业ID
     */
    public void setCompanyidId(Integer companyidId) {
        this.companyidId = companyidId;
    }

    /**
     * 获取工龄
     *
     * @return staff_seniority - 工龄
     */
    public Double getStaffSeniority() {
        return staffSeniority;
    }

    /**
     * 设置工龄
     *
     * @param staffSeniority 工龄
     */
    public void setStaffSeniority(Double staffSeniority) {
        this.staffSeniority = staffSeniority;
    }

    /**
     * 获取家庭情况
     *
     * @return staff_homeInfo - 家庭情况
     */
    public String getStaffHomeinfo() {
        return staffHomeinfo;
    }

    /**
     * 设置家庭情况
     *
     * @param staffHomeinfo 家庭情况
     */
    public void setStaffHomeinfo(String staffHomeinfo) {
        this.staffHomeinfo = staffHomeinfo;
    }

    /**
     * 获取头像连接
     *
     * @return staff_icon - 头像连接
     */
    public String getStaffIcon() {
        return staffIcon;
    }

    /**
     * 设置头像连接
     *
     * @param staffIcon 头像连接
     */
    public void setStaffIcon(String staffIcon) {
        this.staffIcon = staffIcon;
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