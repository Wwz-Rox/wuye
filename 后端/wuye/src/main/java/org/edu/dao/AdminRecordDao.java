package org.edu.dao;

import org.edu.bo.adminRecord.QryAdminRecordReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.AdminRecord;

import java.util.List;

public interface AdminRecordDao {
    //删除
    int deleteByPrimaryKey(Long adminRecordId);

    int insert(AdminRecord record);

    int insertSelective(AdminRecord record);

    AdminRecord selectByPrimaryKey(Long adminRecordId);

    int updateByPrimaryKeySelective(AdminRecord record);

    int updateByPrimaryKey(AdminRecord record);

    //查询列表
    List<AdminRecord> selectAdminRecord(QryAdminRecordReqBO qryAdminRecordReqBO, Page<AdminRecord> page);
    //查询列表--导出Excel用
    List<AdminRecord> selectAdminRecordToGetExcel();
}