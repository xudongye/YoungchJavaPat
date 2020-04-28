package com.youngch.pat.log.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yexudong
 * @Date: 2020/4/23 9:28
 */
@Document(collection = "devicerunlog")
public class DeviceRunLog implements Serializable {

    @Id
    private String id;
    private String bindingId;
    private String propertyValue;
    private Date createTime;
    private long orgId;
    private long groupId;
    private long brandId;
    private String orgName;
    private String roomNo;
    private String devName;
    private String devId;
    private String bindingDevName;
    private String source;

    public DeviceRunLog() {
    }

    @PersistenceConstructor
    public DeviceRunLog(String bindingId, String propertyValue, Date createTime, long orgId, long groupId, long brandId, String orgName, String roomNo, String devName, String devId, String bindingDevName, String source) {
        this.bindingId = bindingId;
        this.propertyValue = propertyValue;
        this.createTime = createTime;
        this.orgId = orgId;
        this.groupId = groupId;
        this.brandId = brandId;
        this.orgName = orgName;
        this.roomNo = roomNo;
        this.devName = devName;
        this.devId = devId;
        this.bindingDevName = bindingDevName;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getBindingDevName() {
        return bindingDevName;
    }

    public void setBindingDevName(String bindingDevName) {
        this.bindingDevName = bindingDevName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
