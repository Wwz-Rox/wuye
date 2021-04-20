package org.edu.bo.adminRecord;

import org.edu.common.page.BO.ReqPageBO;

import java.util.Date;

public class QryAdminRecordReqBO extends ReqPageBO {
    private String adminRecordName;

    private Date startTime;
    private Date endTime;

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

    public String getAdminRecordName() {
        return adminRecordName;
    }

    public void setAdminRecordName(String adminRecordName) {
        this.adminRecordName = adminRecordName;
    }

    @Override
    public String toString() {
        return "QryAdminRecordReqBO{" +
                "adminRecordName='" + adminRecordName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
