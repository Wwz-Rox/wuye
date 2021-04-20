package org.edu.service;

import org.edu.bo.repairRecord.QryRepairRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.RepairRecord;


public interface RepairRecordService {

    RspPageBO<RepairRecord> qryRepairRecord(QryRepairRecordReqBO qryRepairRecordReqBO);
    int deleteRepairRecord(Long record);
}
