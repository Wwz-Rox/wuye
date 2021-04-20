package org.edu.bo.household;

import org.edu.common.page.BO.ReqPageBO;

/**
 * 标题:查询租户
 */
public class QryHouseholdReqBO extends ReqPageBO {

    private String householdName;

    private String householdCardid;

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getHouseholdCardid() {
        return householdCardid;
    }

    public void setHouseholdCardid(String householdCardid) {
        this.householdCardid = householdCardid;
    }

    @Override
    public String toString() {
        return "QryHouseholdReqBO{" +
                "householdName='" + householdName + '\'' +
                ", householdCardid='" + householdCardid + '\'' +
                '}';
    }
}
