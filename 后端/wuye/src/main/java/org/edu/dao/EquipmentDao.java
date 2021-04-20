package org.edu.dao;

import org.edu.bo.equipment.AddEquipmentReqBO;
import org.edu.bo.equipment.EditEquipmentReqBO;
import org.edu.bo.equipment.QryEquipmentReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Equipment;

import java.util.List;

public interface EquipmentDao {
    //添加设备
    int insertEquipment(AddEquipmentReqBO addEquipmentReqBO);
    //查询设备是否存在
    Equipment selectEquipmentIsExist(String equipmentName);
    //查询设备
    List<Equipment> selecttoEquipment(QryEquipmentReqBO qryEquipmentReqBO, Page<Equipment> page);
    //删除设备
    int deleteByPrimaryKey(Long equipmentId);
    //编辑设备
    Equipment selectByPrimaryKey(Long equipmentId);
    int updateByPrimaryKeySelective(EditEquipmentReqBO editEquipmentReqBO);

}