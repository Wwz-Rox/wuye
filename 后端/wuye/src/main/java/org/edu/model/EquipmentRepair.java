package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EquipmentRepair {
    private Long equRepairId;

    private String equRepairName;

    private String equRepairAddr;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date equRepairDate;

    private String status;

    private String note;

    private String equRepairPerson;

    public Long getEquRepairId() {
        return equRepairId;
    }

    public void setEquRepairId(Long equRepairId) {
        this.equRepairId = equRepairId;
    }

    public String getEquRepairName() {
        return equRepairName;
    }

    public void setEquRepairName(String equRepairName) {
        this.equRepairName = equRepairName == null ? null : equRepairName.trim();
    }

    public String getEquRepairAddr() {
        return equRepairAddr;
    }

    public void setEquRepairAddr(String equRepairAddr) {
        this.equRepairAddr = equRepairAddr == null ? null : equRepairAddr.trim();
    }

    public Date getEquRepairDate() {
        return equRepairDate;
    }

    public void setEquRepairDate(Date equRepairDate) {
        this.equRepairDate = equRepairDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getEquRepairPerson() {
        return equRepairPerson;
    }

    public void setEquRepairPerson(String equRepairPerson) {
        this.equRepairPerson = equRepairPerson == null ? null : equRepairPerson.trim();
    }
}