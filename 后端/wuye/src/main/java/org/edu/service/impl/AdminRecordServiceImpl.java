package org.edu.service.impl;

import org.edu.bo.adminRecord.QryAdminRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.AdminRecordDao;
import org.edu.model.AdminRecord;
import org.edu.service.AdminRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdminRecordServiceImpl implements AdminRecordService {
    private final static Logger logger = LoggerFactory.getLogger(AdminRecordServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private AdminRecordDao adminRecordDao;
    //******************************查询管理员记录列表********************************************************************
    @Override
    public RspPageBO<AdminRecord> QryAdminRecord(QryAdminRecordReqBO qryAdminRecordReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询管理员记录列表服务入参{}" + qryAdminRecordReqBO.toString());
        }
        RspPageBO<AdminRecord> rspPageBO = new RspPageBO<AdminRecord>();
        try{
            Page<AdminRecord> page = new Page<AdminRecord>(qryAdminRecordReqBO.getPageNo(),qryAdminRecordReqBO.getPageSize());
            List<AdminRecord> adminList=adminRecordDao.selectAdminRecord(qryAdminRecordReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryAdminRecordReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询管理员列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //***********************导出Excel**********************************************************
    @Override
    public List<AdminRecord> QryAdminRecordToExcel() {
        return adminRecordDao.selectAdminRecordToGetExcel();
    }

    //***********************删除管理员**********************************************************
    @Override
    public int deleteAdminRecord(Long adminRecordId) {
        if (isDebugEnabled) {
            logger.debug("查询管理员记录列表服务入参{}" + adminRecordId);
        }
        return adminRecordDao.deleteByPrimaryKey(adminRecordId);
    }



}
