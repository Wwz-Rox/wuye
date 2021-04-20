package org.edu.dao;

import org.edu.bo.repairRecord.QryRepairRecordReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.RepairRecord;

import java.util.List;

public interface RepairRecordDao {
    //删除记录列表
    int deleteByPrimaryKey(Long recordId);

    int insert(RepairRecord record);

    int insertSelective(RepairRecord record);

    RepairRecord selectByPrimaryKey(Long record);

    int updateByPrimaryKeySelective(RepairRecord record);

    int updateByPrimaryKey(RepairRecord record);

    //查询记录列表
    List<RepairRecord> selectRecord(QryRepairRecordReqBO qryRepairRecordReqBO, Page<RepairRecord> page);

    //插入记录表
//    int insertRecord();
}