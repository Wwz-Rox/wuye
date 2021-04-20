package org.edu.bo.equipmentRepair;

import org.edu.common.page.BO.ReqPageBO;

/**
 * 标题:查询设备报修
 */
public class QryEquipmentRepairReqBO extends ReqPageBO {
    private String equRepairName;

    public String getEquRepairName() {
        return equRepairName;
    }

    public void setEquRepairName(String equRepairName) {
        this.equRepairName = equRepairName;
    }

    @Override
    public String toString() {
        return "QryEquipmentRepairReqBO{" +
                "equRepairName='" + equRepairName + '\'' +
                '}';
    }
}
