package org.edu.service;

import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.PayRecord;

public interface PayMoneyRecordService {
    //查询缴费记录
    RspPageBO<PayRecord> QryPayRecord(QryPayRecordReqBO qryPayRecordReqBO);
    //删除缴费记录
    int deletePayRecord(Integer pcordId);
}
