package org.edu.dao;

import org.edu.bo.equipmentRepair.AddEquipmentRepairReqBO;
import org.edu.bo.equipmentRepair.QryEquipmentRepairReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.EquipmentRepair;

import java.util.List;

public interface EquipmentRepairDao {
    //删除
    int deleteByPrimaryKey(Long equRepairId);

    int insert(EquipmentRepair record);
    //添加
    int insertSelective(AddEquipmentRepairReqBO record);

    EquipmentRepair selectByPrimaryKey(Long equRepairId);

    int updateByPrimaryKeySelective(EquipmentRepair record);
    //更新状态
    int updateByPrimaryKey(Long equRepairId);

    //查询
    List<EquipmentRepair> selectEquipmentRepair(QryEquipmentRepairReqBO qryEquipmentRepairReqBO, Page<EquipmentRepair> page);

    //插入记录表
    int insertRecord(Long equRepairId);
    //查询设备是否报修
    EquipmentRepair selectIsRepair(String equRepairName);
}