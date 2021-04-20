package org.edu.bo.equipment;

import org.edu.common.page.BO.ReqPageBO;

import java.util.Date;

public class QryEquipmentReqBO extends ReqPageBO {
    private Date startTime;
    private Date endTime;
    private String equipmentName;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public String toString() {
        return "QryEquipmentReqBO{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", equipmentName='" + equipmentName + '\'' +
                '}';
    }
}
