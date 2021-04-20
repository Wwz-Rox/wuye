package org.edu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PayRecord {
    private Integer pcordId;

    private String pcordName;

    private String pcordAdrr;

    private String pcordCard;

    private String pcordType;

    private Long pcordNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date pcordTime;

    public Integer getPcordId() {
        return pcordId;
    }

    public void setPcordId(Integer pcordId) {
        this.pcordId = pcordId;
    }

    public String getPcordName() {
        return pcordName;
    }

    public void setPcordName(String pcordName) {
        this.pcordName = pcordName == null ? null : pcordName.trim();
    }

    public String getPcordAdrr() {
        return pcordAdrr;
    }

    public void setPcordAdrr(String pcordAdrr) {
        this.pcordAdrr = pcordAdrr == null ? null : pcordAdrr.trim();
    }

    public String getPcordCard() {
        return pcordCard;
    }

    public void setPcordCard(String pcordCard) {
        this.pcordCard = pcordCard == null ? null : pcordCard.trim();
    }

    public String getPcordType() {
        return pcordType;
    }

    public void setPcordType(String pcordType) {
        this.pcordType = pcordType == null ? null : pcordType.trim();
    }

    public Long getPcordNum() {
        return pcordNum;
    }

    public void setPcordNum(Long pcordNum) {
        this.pcordNum = pcordNum;
    }

    public Date getPcordTime() {
        return pcordTime;
    }

    public void setPcordTime(Date pcordTime) {
        this.pcordTime = pcordTime;
    }
}