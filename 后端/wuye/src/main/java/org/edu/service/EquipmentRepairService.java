package org.edu.service;

import org.edu.bo.equipmentRepair.AddEquipmentRepairReqBO;
import org.edu.bo.equipmentRepair.QryEquipmentRepairReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.EquipmentRepair;

/**
 * 标题:设备报修模块Service层
 */
public interface EquipmentRepairService {

    //删除
    int deleteEquipmentRepair(Long equRepairId);

    //更新状态
    int updateEquipmentRepair(Long equRepairId);

    //查询报修
    RspPageBO<EquipmentRepair> qryEquipmentRepair(QryEquipmentRepairReqBO qryEquipmentRepairReqBO);

    //添加报修
    int addEquipmentRepair(AddEquipmentRepairReqBO addEquipmentRepairReqBO);
}
