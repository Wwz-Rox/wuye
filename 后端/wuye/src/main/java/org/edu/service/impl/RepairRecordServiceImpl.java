package org.edu.service.impl;

import org.edu.bo.repairRecord.QryRepairRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.RepairRecordDao;
import org.edu.model.RepairRecord;
import org.edu.service.RepairRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标题:维修记录
 */
@Service
public class RepairRecordServiceImpl implements RepairRecordService {
    private final static Logger logger = LoggerFactory.getLogger(RepairRecordServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private RepairRecordDao repairRecordDao;
    //******************************查询维修记录********************************************************************
    @Override
    public RspPageBO<RepairRecord> qryRepairRecord(QryRepairRecordReqBO qryRepairRecordReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询记录列表服务入参{}" + qryRepairRecordReqBO.toString());
        }
        RspPageBO<RepairRecord> rspPageBO = new RspPageBO<RepairRecord>();
        try{
            Page<RepairRecord> page = new Page<RepairRecord>(qryRepairRecordReqBO.getPageNo(),qryRepairRecordReqBO.getPageSize());
            List<RepairRecord> list=repairRecordDao.selectRecord(qryRepairRecordReqBO,page);
            rspPageBO.setRows(list);
            rspPageBO.setPageNo(qryRepairRecordReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询记录列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除维修记录********************************************************************
    @Override
    public int deleteRepairRecord(Long record) {
        if (isDebugEnabled) {
            logger.debug("删除维修记录服务入参{}" + record);
        }
        return repairRecordDao.deleteByPrimaryKey(record);
    }
}
