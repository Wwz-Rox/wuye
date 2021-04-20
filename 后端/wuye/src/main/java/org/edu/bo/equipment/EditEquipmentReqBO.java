package org.edu.bo.equipment;

public class EditEquipmentReqBO {
    private Long equipmentId;

    private String equipmentName;

    private String equipmentAddr;

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
        return "EditEquipmentReqBO{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentAddr='" + equipmentAddr + '\'' +
                ", note='" + note + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                '}';
    }
}
