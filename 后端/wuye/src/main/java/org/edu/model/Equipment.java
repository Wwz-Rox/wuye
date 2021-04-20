package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Equipment {
    private Long equipmentId;

    private String equipmentName;

    private String equipmentAddr;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date stallTime;

    private String note;

    private String equipmentType;

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentAddr() {
        return equipmentAddr;
    }

    public void setEquipmentAddr(String equipmentAddr) {
        this.equipmentAddr = equipmentAddr == null ? null : equipmentAddr.trim();
    }

    public Date getStallTime() {
        return stallTime;
    }

    public void setStallTime(Date stallTime) {
        this.stallTime = stallTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }
}