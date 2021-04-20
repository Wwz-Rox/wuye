package org.edu.dao;

import org.edu.bo.repairPerson.AddRepairPersonReqBO;
import org.edu.bo.repairPerson.EditRepairPersonReqBO;
import org.edu.bo.repairPerson.QryRepairPersonReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.RepairPerson;

import java.util.List;
import java.util.Map;

public interface RepairPersonDao {
    //删除维修人员
    int deleteByPrimaryKey(Integer repairId);
    //添加维修人员
    int insertSelective(AddRepairPersonReqBO record);
    //编辑维修人员
    RepairPerson selectByPrimaryKey(Integer repairId);
    int updateByPrimaryKeySelective(EditRepairPersonReqBO record);
    //查询维修人员
    List<RepairPerson> selectRepairPerson(QryRepairPersonReqBO qryRepairPersonReqBO,Page<RepairPerson> page);
    //equ_repair_id入值
    int updateEqurepairid();
    //查询维修人员是否存在
    RepairPerson selectPersonIsExist(Map<String, Object> params);
    int updateByPrimaryKey(RepairPerson record);
    int insert(RepairPerson record);
}