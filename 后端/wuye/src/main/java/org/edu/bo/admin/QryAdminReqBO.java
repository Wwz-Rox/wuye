package org.edu.bo.admin;

import org.edu.common.page.BO.ReqPageBO;

import java.util.Date;

/**
 * 标题:查询管理员服务
 */
public class QryAdminReqBO extends ReqPageBO {
    private String adminName;
    private Date startTime;
    private Date endTime;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
        return "QryAdminReqBO{" +
                "adminName='" + adminName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
