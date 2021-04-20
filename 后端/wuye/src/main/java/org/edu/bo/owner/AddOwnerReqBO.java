package org.edu.bo.owner;

import java.util.Date;

public class AddOwnerReqBO {
    private String ownerName;

    private String ownerCardid;

    private String ownerPhone;

    private String ownerContract;

//    private Date buyDate;

    private String workPlace;

    private String houseAddress;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerCardid() {
        return ownerCardid;
    }

    public void setOwnerCardid(String ownerCardid) {
        this.ownerCardid = ownerCardid == null ? null : ownerCardid.trim();
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone == null ? null : ownerPhone.trim();
    }

    public String getOwnerContract() {
        return ownerContract;
    }

    public void setOwnerContract(String ownerContract) {
        this.ownerContract = ownerContract == null ? null : ownerContract.trim();
    }

//    public Date getBuyDate() {
//        return buyDate;
//    }
//
//    public void setBuyDate(Date buyDate) {
//        this.buyDate = buyDate;
//    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    @Override
    public String toString() {
        return "AddOwnerReqBO{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerCardid='" + ownerCardid + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", ownerContract='" + ownerContract + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                '}';
    }
}
