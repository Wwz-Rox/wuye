package org.edu.bo.repairPerson;


public class EditRepairPersonReqBO {
    private String repairName;

    private String repairTel;

    private String repairNum;

    private String company;

    private Integer repairId;

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairTel() {
        return repairTel;
    }

    public void setRepairTel(String repairTel) {
        this.repairTel = repairTel;
    }

    public String getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    @Override
    public String toString() {
        return "EditRepairPersonReqBO{" +
                "repairName='" + repairName + '\'' +
                ", repairTel='" + repairTel + '\'' +
                ", repairNum='" + repairNum + '\'' +
                ", company='" + company + '\'' +
                ", repairId=" + repairId +
                '}';
    }
}
