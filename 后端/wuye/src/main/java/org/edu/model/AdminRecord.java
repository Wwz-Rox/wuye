package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AdminRecord {
    private Long adminRecordId;

    private String adminRecordName;

    private String adminRecordRole;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date adminRecordTime;

    private String adminRecordTel;

    public Long getAdminRecordId() {
        return adminRecordId;
    }

    public void setAdminRecordId(Long adminRecordId) {
        this.adminRecordId = adminRecordId;
    }

    public String getAdminRecordName() {
        return adminRecordName;
    }

    public void setAdminRecordName(String adminRecordName) {
        this.adminRecordName = adminRecordName == null ? null : adminRecordName.trim();
    }

    public String getAdminRecordRole() {
        return adminRecordRole;
    }

    public void setAdminRecordRole(String adminRecordRole) {
        this.adminRecordRole = adminRecordRole == null ? null : adminRecordRole.trim();
    }

    public Date getAdminRecordTime() {
        return adminRecordTime;
    }

    public void setAdminRecordTime(Date adminRecordTime) {
        this.adminRecordTime = adminRecordTime;
    }

    public String getAdminRecordTel() {
        return adminRecordTel;
    }

    public void setAdminRecordTel(String adminRecordTel) {
        this.adminRecordTel = adminRecordTel == null ? null : adminRecordTel.trim();
    }
}