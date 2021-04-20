package org.edu.model;

public class RepairPerson {
    private Integer repairId;

    private Long equRepairId;

    private String repairName;

    private String repairTel;

    private String repairNum;

    private String company;

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Long getEquRepairId() {
        return equRepairId;
    }

    public void setEquRepairId(Long equRepairId) {
        this.equRepairId = equRepairId;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName == null ? null : repairName.trim();
    }

    public String getRepairTel() {
        return repairTel;
    }

    public void setRepairTel(String repairTel) {
        this.repairTel = repairTel == null ? null : repairTel.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
    }
}