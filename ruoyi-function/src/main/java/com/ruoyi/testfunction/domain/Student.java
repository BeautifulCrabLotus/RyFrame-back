package com.ruoyi.testfunction.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 stu_student
 *
 * @author LF
 * @date 2023-01-04
 */
public class Student extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 学生名称
     */
    @Excel(name = "学生名称")
    private String studentName;

    /**
     * 年龄
     */
    @Excel(name = "年龄")
    private Long studentAge;

    /**
     * 爱好（0代码 1音乐 2电影）
     */
    @Excel(name = "爱好", readConverterExp = "0=代码,1=音乐,2=电影")
    private String studentHobby;

    /**
     * 性别（0男 1女 2未知）
     */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String studentSex;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date studentBirthday;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 数据状态
     */
    @Excel(name = "数据状态")
    private Long status;

    /**
     * 版本
     */
    @Excel(name = "版本")
    private Long version;

    /**
     * UUID
     */
    @Excel(name = "UUID")
    private String uuid;

    /**
     * 租户ID
     */
    @Excel(name = "租户ID")
    private Long tenantId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentAge(Long studentAge) {
        this.studentAge = studentAge;
    }

    public Long getStudentAge() {
        return studentAge;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }

    public String getStudentHobby() {
        return studentHobby;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("studentName", getStudentName())
                .append("studentAge", getStudentAge())
                .append("studentHobby", getStudentHobby())
                .append("studentSex", getStudentSex())
                .append("studentBirthday", getStudentBirthday())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("version", getVersion())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("uuid", getUuid())
                .append("remark", getRemark())
                .append("tenantId", getTenantId())
                .toString();
    }
}
