package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Household {
    private Long householdId;

    private String householdName;

    private String ownerName;

    private String householdCardid;

    private String householdPhone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date liveDate;

    private String liveTime;

    private String houseAddr;

    public Long getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Long householdId) {
        this.householdId = householdId;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName == null ? null : householdName.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getHouseholdCardid() {
        return householdCardid;
    }

    public void setHouseholdCardid(String householdCardid) {
        this.householdCardid = householdCardid == null ? null : householdCardid.trim();
    }

    public String getHouseholdPhone() {
        return householdPhone;
    }

    public void setHouseholdPhone(String householdPhone) {
        this.householdPhone = householdPhone == null ? null : householdPhone.trim();
    }

    public Date getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(Date liveDate) {
        this.liveDate = liveDate;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime == null ? null : liveTime.trim();
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr == null ? null : houseAddr.trim();
    }
}