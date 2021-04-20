package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Pay {
    private Integer payId;

    private String payName;

    private String payTel;

    private String payBuildNum;

    private String payUnitNum;

    private String payHouseNum;

    private String payType;

    private Long payMoneyNum;

    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public String getPayTel() {
        return payTel;
    }

    public void setPayTel(String payTel) {
        this.payTel = payTel == null ? null : payTel.trim();
    }

    public String getPayBuildNum() {
        return payBuildNum;
    }

    public void setPayBuildNum(String payBuildNum) {
        this.payBuildNum = payBuildNum == null ? null : payBuildNum.trim();
    }

    public String getPayUnitNum() {
        return payUnitNum;
    }

    public void setPayUnitNum(String payUnitNum) {
        this.payUnitNum = payUnitNum == null ? null : payUnitNum.trim();
    }

    public String getPayHouseNum() {
        return payHouseNum;
    }

    public void setPayHouseNum(String payHouseNum) {
        this.payHouseNum = payHouseNum == null ? null : payHouseNum.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Long getPayMoneyNum() {
        return payMoneyNum;
    }

    public void setPayMoneyNum(Long payMoneyNum) {
        this.payMoneyNum = payMoneyNum;
    }
}