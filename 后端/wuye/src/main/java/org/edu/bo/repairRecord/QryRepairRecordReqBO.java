package org.edu.bo.repairRecord;

import org.edu.common.page.BO.ReqPageBO;

import java.util.Date;


public class QryRepairRecordReqBO extends ReqPageBO {
    private String repPerson;
    private Date startTime;
    private Date endTime;

    public String getRepPerson() {
        return repPerson;
    }

    public void setRepPerson(String repPerson) {
        this.repPerson = repPerson;
    }

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

    @Override
    public String toString() {
        return "QryRepairRecordReqBO{" +
                "repPerson='" + repPerson + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
