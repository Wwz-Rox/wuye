package org.edu.bo.repairPerson;

import org.edu.common.page.BO.ReqPageBO;

/**
 * 标题:查询维修人员
 */
public class QryRepairPersonReqBO extends ReqPageBO {
    private String repairName;

    private String repairNum;

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
    }

    @Override
    public String toString() {
        return "QryRepairPersonReqBO{" +
                "repairName='" + repairName + '\'' +
                ", repairNum='" + repairNum + '\'' +
                '}';
    }
}
