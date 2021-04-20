package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RepairRecord {
    private Long recordId;

    private String recordName;

    private String recordAddr;

    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date askrepairTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date repTime;

    private String repPerson;

    private String repCompany;

    private String repairNum;

    private String repairPhone;

    public String getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
    }

    public String getRepCompany() {
        return repCompany;
    }

    public void setRepCompany(String repCompany) {
        this.repCompany = repCompany;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
    }

    public String getRecordAddr() {
        return recordAddr;
    }

    public void setRecordAddr(String recordAddr) {
        this.recordAddr = recordAddr == null ? null : recordAddr.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getAskrepairTime() {
        return askrepairTime;
    }

    public void setAskrepairTime(Date askrepairTime) {
        this.askrepairTime = askrepairTime;
    }

    public Date getRepTime() {
        return repTime;
    }

    public void setRepTime(Date repTime) {
        this.repTime = repTime;
    }

    public String getRepPerson() {
        return repPerson;
    }

    public void setRepPerson(String repPerson) {
        this.repPerson = repPerson == null ? null : repPerson.trim();
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }
}