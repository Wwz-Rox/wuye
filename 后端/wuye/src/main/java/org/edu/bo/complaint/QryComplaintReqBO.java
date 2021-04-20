package org.edu.bo.complaint;

import org.edu.common.page.BO.ReqPageBO;

import java.util.Date;
public class QryComplaintReqBO extends ReqPageBO {
    private String complaintTitle;
    private Date startTime;
    private Date endTime;

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
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
        return "QryComplaintReqBO{" +
                "complaintTitle='" + complaintTitle + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
