package com.ruoyi.testfunction.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【智慧物联】地址信息对象 screen_iot_address
 *
 * @author LF
 * @date 2023-01-04
 */
public class ScreenIotAddress extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 地址ID
     */
    @Excel(name = "地址ID")
    private Long addressId;

    /**
     * 分组名称(第三方视频分组名称)
     */
    @Excel(name = "分组名称(第三方视频分组名称)")
    private String groupName;

    /**
     * 地址名称
     */
    @Excel(name = "地址名称")
    private String addressName;

    /**
     * 别名
     */
    @Excel(name = "别名")
    private String aliasName;

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

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getAliasName() {
        return aliasName;
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
                .append("addressId", getAddressId())
                .append("groupName", getGroupName())
                .append("addressName", getAddressName())
                .append("aliasName", getAliasName())
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
