package org.edu.bo.equipment;

import java.util.Date;


public class AddEquipmentReqBO {
    private String equipmentName;

    private String equipmentAddr;

//    private Date stallTime;

    private String note;

    private String equipmentType;

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

//    public Date getStallTime() {
//        return stallTime;
//    }
//
//    public void setStallTime(Date stallTime) {
//        this.stallTime = stallTime;
//    }

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

    @Override
    public String toString() {
        return "AddEquipmentReqBO{" +
                "equipmentName='" + equipmentName + '\'' +
                ", equipmentAddr='" + equipmentAddr + '\'' +
                ", note='" + note + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                '}';
    }
}
