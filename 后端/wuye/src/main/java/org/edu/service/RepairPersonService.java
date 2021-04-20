package org.edu.service;

import org.edu.bo.repairPerson.AddRepairPersonReqBO;
import org.edu.bo.repairPerson.EditRepairPersonReqBO;
import org.edu.bo.repairPerson.QryRepairPersonReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.RepairPerson;

/**
 * 标题:维修人员模块Service
 */
public interface RepairPersonService {
    //查询维修人员
    RspPageBO<RepairPerson> qryRepairPerson(QryRepairPersonReqBO qryRepairPersonReqBO);

    //添加维修人员
    int addRepairPerson(AddRepairPersonReqBO addRepairPersonReqBO);

    //删除维修人员
    int deleteRepairPerson(Integer repairId);

    //编辑维修人员
    RepairPerson selectRepairPerson(Integer repairId);
    int updateRepairPerson(EditRepairPersonReqBO editRepairPersonReqBO);
}
