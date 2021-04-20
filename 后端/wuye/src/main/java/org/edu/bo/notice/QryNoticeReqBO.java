package org.edu.bo.notice;

import org.edu.common.page.BO.ReqPageBO;

import java.util.Date;

public class QryNoticeReqBO extends ReqPageBO {
    private String noticeTitle;
    private Date startTime;
    private Date endTime;

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
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
        return "QryNoticeReqBO{" +
                "noticeTitle='" + noticeTitle + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
