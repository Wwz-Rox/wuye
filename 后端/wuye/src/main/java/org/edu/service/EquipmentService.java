package org.edu.service;

import org.edu.bo.equipment.AddEquipmentReqBO;
import org.edu.bo.equipment.EditEquipmentReqBO;
import org.edu.bo.equipment.QryEquipmentReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Equipment;

/**
 * 标题:设备模块
 */
public interface EquipmentService {
    //查询设备
    RspPageBO<Equipment> qryEquipment(QryEquipmentReqBO qryEquipmentReqBO);
    //添加设备
    int addEquipment(AddEquipmentReqBO addEquipmentReqBO );
    //删除设备
    int deleteEquipment(Long equipmentId);
    //编辑设备
    Equipment selectEquipment(Long equipmentId);
    int updateEquipment(EditEquipmentReqBO editEquipmentReqBO);
}
