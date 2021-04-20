package org.edu.service;

import org.edu.bo.adminRecord.QryAdminRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.AdminRecord;

import java.util.List;


public interface AdminRecordService {

    //查询管理员记录
    RspPageBO<AdminRecord> QryAdminRecord(QryAdminRecordReqBO qryAdminRecordReqBO);
    //查询管理员记录----导出EXcel用
    List<AdminRecord> QryAdminRecordToExcel();
    //删除管理员记录
    int deleteAdminRecord(Long adminRecordId);


}
