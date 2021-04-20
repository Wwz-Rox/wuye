package org.edu.service.impl;

import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.PayRecordDao;
import org.edu.model.Pay;
import org.edu.model.PayRecord;
import org.edu.service.PayMoneyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标题:缴费记录模块
 */
@Service
public class PayMoneyRecordServiceImpl implements PayMoneyRecordService {
    private final static Logger logger = LoggerFactory.getLogger(PayMoneyRecordServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private PayRecordDao payRecordDao;


    //******************************查询缴费记录********************************************************************
    @Override
    public RspPageBO<PayRecord> QryPayRecord(QryPayRecordReqBO qryPayRecordReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询缴费记录服务入参{}" + qryPayRecordReqBO.toString());
        }
        RspPageBO<PayRecord> rspPageBO = new RspPageBO<PayRecord>();
        try{
            Page<PayRecord> page = new Page<PayRecord>(qryPayRecordReqBO.getPageNo(),qryPayRecordReqBO.getPageSize());
            List<PayRecord> payRecordList=payRecordDao.selectPayRecord(qryPayRecordReqBO,page);
            rspPageBO.setRows(payRecordList);
            rspPageBO.setPageNo(qryPayRecordReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询缴费记录服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除缴费记录********************************************************************
    @Override
    public int deletePayRecord(Integer pcordId) {
        if (isDebugEnabled) {
            logger.debug("删除缴费记录服务入参{}" + pcordId);
        }
        try {
            int result=payRecordDao.deleteByPrimaryKey(pcordId);
            if(result==0){
                logger.error("删除缴费记录服务失败啦");
            }
            return result;
        }catch(Exception e){
            logger.error("删除缴费记录服务失败啦", e);
            throw new RuntimeException();
        }

    }
}
