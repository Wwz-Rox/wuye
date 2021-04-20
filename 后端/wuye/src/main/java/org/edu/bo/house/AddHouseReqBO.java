package org.edu.bo.house;

/**
 * 标题:添加房屋
 */
public class AddHouseReqBO {
    private String buildingNumber;

    private String unitNumber;

    private String houseNumber;

    private String houseSize;

    private String note;

    private String houseType;

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber == null ? null : buildingNumber.trim();
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber == null ? null : unitNumber.trim();
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber == null ? null : houseNumber.trim();
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize == null ? null : houseSize.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    @Override
    public String toString() {
        return "AddHouseReqBO{" +
                "buildingNumber='" + buildingNumber + '\'' +
                ", unitNumber='" + unitNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseSize='" + houseSize + '\'' +
                ", note='" + note + '\'' +
                ", houseType='" + houseType + '\'' +
                '}';
    }
}
