package org.edu.service.impl;

import org.edu.bo.money.PayMoneyReqBO;
import org.edu.bo.money.QryPayReqBO;
import org.edu.bo.money.UpdatePayMoneyReqBO;
import org.edu.dao.PayDao;
import org.edu.dao.PayRecordDao;
import org.edu.model.Pay;
import org.edu.model.PayRecord;
import org.edu.service.PayMoneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 标题:缴费模块实现类
 */
@Service
public class PayMoneyServiceImpl implements PayMoneyService {
    private final static Logger logger = LoggerFactory.getLogger(PayMoneyServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private PayDao payDao;
    @Autowired
    private PayRecordDao payRecordDao;
    //******************************缴水费********************************************************************
    @Override
    public int addpayMoneyWater(PayMoneyReqBO payMoneyReqBO) {
        if (isDebugEnabled) {
            logger.debug("缴费服务入参{}" + payMoneyReqBO.toString());
        }
        payMoneyReqBO.setPayType("水费");
        QryPayReqBO qryPayReqBO=new QryPayReqBO();
        qryPayReqBO.setPayname(payMoneyReqBO.getPayName());
        qryPayReqBO.setPaycard(payMoneyReqBO.getIdCard());
        qryPayReqBO.setPaytype(payMoneyReqBO.getPayType());
        qryPayReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
        qryPayReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
        qryPayReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
        Pay pay=payDao.selectPayInfo(qryPayReqBO);
        PayRecord payRecord=new PayRecord();
        String adrr=payMoneyReqBO.getPayBuildNum()+payMoneyReqBO.getPayUnitNum()+payMoneyReqBO.getPayHouseNum();
        if(null == pay){
//            payMoneyReqBO.setPayType("水费");
            //插入缴费记录表
//            logger.debug("插入缴费记录表{}" );
            payRecord.setPcordAdrr(adrr);
            payRecord.setPcordCard(payMoneyReqBO.getIdCard());
            payRecord.setPcordName(payMoneyReqBO.getPayName());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordType(payMoneyReqBO.getPayType());
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表地址"+ payRecord.getPcordAdrr());
            int success = payDao.insertSelective(payMoneyReqBO);
            if(success ==0){
                logger.error("插入缴费记录服务失败啦");
            }
            return success;
        }else{
//            logger.debug("更新缴费记录表{}" );
            UpdatePayMoneyReqBO updatePayMoneyReqBO=new UpdatePayMoneyReqBO();
            updatePayMoneyReqBO.setIdCard(payMoneyReqBO.getIdCard());
            updatePayMoneyReqBO.setPayMoney(payMoneyReqBO.getPayMoney());
            updatePayMoneyReqBO.setPayName(payMoneyReqBO.getPayName());
            updatePayMoneyReqBO.setPaytype(payMoneyReqBO.getPayType());
            updatePayMoneyReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
            updatePayMoneyReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
            updatePayMoneyReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
            //插入缴费记录表
            payRecord.setPcordType(pay.getPayType());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordName(pay.getPayName());
            payRecord.setPcordCard(pay.getIdCard());
            payRecord.setPcordAdrr(adrr);
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表{名字}"+ payRecord.getPcordName());
            try{
            int success = payDao.updateByPrimaryKeySelective(updatePayMoneyReqBO);
            if(success ==0){
                logger.error("更新记录服务失败啦");
            }

            return  success;
        }catch(Exception e){
            logger.error("缴费服务失败啦", e);
            throw new RuntimeException();
        }
        }
    }
    //******************************缴电费********************************************************************
    @Override
    public int addpayMoneyEle(PayMoneyReqBO payMoneyReqBO) {
        if (isDebugEnabled) {
            logger.debug("缴费服务入参{}" + payMoneyReqBO.toString());
        }
        payMoneyReqBO.setPayType("电费");
        QryPayReqBO qryPayReqBO=new QryPayReqBO();
        qryPayReqBO.setPayname(payMoneyReqBO.getPayName());
        qryPayReqBO.setPaycard(payMoneyReqBO.getIdCard());
        qryPayReqBO.setPaytype(payMoneyReqBO.getPayType());
        qryPayReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
        qryPayReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
        qryPayReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
        Pay pay=payDao.selectPayInfo(qryPayReqBO);
        PayRecord payRecord=new PayRecord();
        String adrr=payMoneyReqBO.getPayBuildNum()+payMoneyReqBO.getPayUnitNum()+payMoneyReqBO.getPayHouseNum();
        if(null == pay){
//            payMoneyReqBO.setPayType("水费");
            //插入缴费记录表
//            logger.debug("插入缴费记录表{}" );
            payRecord.setPcordAdrr(adrr);
            payRecord.setPcordCard(payMoneyReqBO.getIdCard());
            payRecord.setPcordName(payMoneyReqBO.getPayName());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordType(payMoneyReqBO.getPayType());
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表地址"+ payRecord.getPcordAdrr());
            int success = payDao.insertSelective(payMoneyReqBO);
            if(success ==0){
                logger.error("插入缴费记录服务失败啦");
            }
            return success;
        }else{
//            logger.debug("更新缴费记录表{}" );
            UpdatePayMoneyReqBO updatePayMoneyReqBO=new UpdatePayMoneyReqBO();
            updatePayMoneyReqBO.setIdCard(payMoneyReqBO.getIdCard());
            updatePayMoneyReqBO.setPayMoney(payMoneyReqBO.getPayMoney());
            updatePayMoneyReqBO.setPayName(payMoneyReqBO.getPayName());
            updatePayMoneyReqBO.setPaytype(payMoneyReqBO.getPayType());
            updatePayMoneyReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
            updatePayMoneyReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
            updatePayMoneyReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
            //插入缴费记录表
            payRecord.setPcordType(pay.getPayType());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordName(pay.getPayName());
            payRecord.setPcordCard(pay.getIdCard());
            payRecord.setPcordAdrr(adrr);
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表{名字}"+ payRecord.getPcordName());
            try{
                int success = payDao.updateByPrimaryKeySelective(updatePayMoneyReqBO);
                if(success ==0){
                    logger.error("更新记录服务失败啦");
                }

                return  success;
            }catch(Exception e){
                logger.error("缴费服务失败啦", e);
                throw new RuntimeException();
            }
        }
    }
    //******************************缴燃气费********************************************************************
    @Override
    public int addpayMoneyGas(PayMoneyReqBO payMoneyReqBO) {
        if (isDebugEnabled) {
            logger.debug("缴费服务入参{}" + payMoneyReqBO.toString());
        }
        payMoneyReqBO.setPayType("燃气费");
        QryPayReqBO qryPayReqBO=new QryPayReqBO();
        qryPayReqBO.setPayname(payMoneyReqBO.getPayName());
        qryPayReqBO.setPaycard(payMoneyReqBO.getIdCard());
        qryPayReqBO.setPaytype(payMoneyReqBO.getPayType());
        qryPayReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
        qryPayReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
        qryPayReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
        Pay pay=payDao.selectPayInfo(qryPayReqBO);
        PayRecord payRecord=new PayRecord();
        String adrr=payMoneyReqBO.getPayBuildNum()+payMoneyReqBO.getPayUnitNum()+payMoneyReqBO.getPayHouseNum();
        if(null == pay){
//            payMoneyReqBO.setPayType("水费");
            //插入缴费记录表
//            logger.debug("插入缴费记录表{}" );
            payRecord.setPcordAdrr(adrr);
            payRecord.setPcordCard(payMoneyReqBO.getIdCard());
            payRecord.setPcordName(payMoneyReqBO.getPayName());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordType(payMoneyReqBO.getPayType());
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表地址"+ payRecord.getPcordAdrr());
            int success = payDao.insertSelective(payMoneyReqBO);
            if(success ==0){
                logger.error("插入缴费记录服务失败啦");
            }
            return success;
        }else{
//            logger.debug("更新缴费记录表{}" );
            UpdatePayMoneyReqBO updatePayMoneyReqBO=new UpdatePayMoneyReqBO();
            updatePayMoneyReqBO.setIdCard(payMoneyReqBO.getIdCard());
            updatePayMoneyReqBO.setPayMoney(payMoneyReqBO.getPayMoney());
            updatePayMoneyReqBO.setPayName(payMoneyReqBO.getPayName());
            updatePayMoneyReqBO.setPaytype(payMoneyReqBO.getPayType());
            updatePayMoneyReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
            updatePayMoneyReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
            updatePayMoneyReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
            //插入缴费记录表
            payRecord.setPcordType(pay.getPayType());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordName(pay.getPayName());
            payRecord.setPcordCard(pay.getIdCard());
            payRecord.setPcordAdrr(adrr);
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表{名字}"+ payRecord.getPcordName());
            try{
                int success = payDao.updateByPrimaryKeySelective(updatePayMoneyReqBO);
                if(success ==0){
                    logger.error("更新记录服务失败啦");
                }

                return  success;
            }catch(Exception e){
                logger.error("缴费服务失败啦", e);
                throw new RuntimeException();
            }
        }
    }
    //******************************缴物业费********************************************************************
    @Override
    public int addpayMoneyWuye(PayMoneyReqBO payMoneyReqBO) {
        if (isDebugEnabled) {
            logger.debug("缴费服务入参{}" + payMoneyReqBO.toString());
        }
        payMoneyReqBO.setPayType("物业费");
        QryPayReqBO qryPayReqBO=new QryPayReqBO();
        qryPayReqBO.setPayname(payMoneyReqBO.getPayName());
        qryPayReqBO.setPaycard(payMoneyReqBO.getIdCard());
        qryPayReqBO.setPaytype(payMoneyReqBO.getPayType());
        qryPayReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
        qryPayReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
        qryPayReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
        Pay pay=payDao.selectPayInfo(qryPayReqBO);
        PayRecord payRecord=new PayRecord();
        String adrr=payMoneyReqBO.getPayBuildNum()+payMoneyReqBO.getPayUnitNum()+payMoneyReqBO.getPayHouseNum();
        if(null == pay){
//            payMoneyReqBO.setPayType("水费");
            //插入缴费记录表
//            logger.debug("插入缴费记录表{}" );
            payRecord.setPcordAdrr(adrr);
            payRecord.setPcordCard(payMoneyReqBO.getIdCard());
            payRecord.setPcordName(payMoneyReqBO.getPayName());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordType(payMoneyReqBO.getPayType());
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表地址"+ payRecord.getPcordAdrr());
            int success = payDao.insertSelective(payMoneyReqBO);
            if(success ==0){
                logger.error("插入缴费记录服务失败啦");
            }
            return success;
        }else{
//            logger.debug("更新缴费记录表{}" );
            UpdatePayMoneyReqBO updatePayMoneyReqBO=new UpdatePayMoneyReqBO();
            updatePayMoneyReqBO.setIdCard(payMoneyReqBO.getIdCard());
            updatePayMoneyReqBO.setPayMoney(payMoneyReqBO.getPayMoney());
            updatePayMoneyReqBO.setPayName(payMoneyReqBO.getPayName());
            updatePayMoneyReqBO.setPaytype(payMoneyReqBO.getPayType());
            updatePayMoneyReqBO.setPaybuild(payMoneyReqBO.getPayBuildNum());
            updatePayMoneyReqBO.setPayunit(payMoneyReqBO.getPayUnitNum());
            updatePayMoneyReqBO.setPayhouse(payMoneyReqBO.getPayHouseNum());
            //插入缴费记录表
            payRecord.setPcordType(pay.getPayType());
            payRecord.setPcordNum(payMoneyReqBO.getPayMoney());
            payRecord.setPcordName(pay.getPayName());
            payRecord.setPcordCard(pay.getIdCard());
            payRecord.setPcordAdrr(adrr);
            payRecordDao.insertSelective(payRecord);
//            logger.debug("缴费记录表{名字}"+ payRecord.getPcordName());
            try{
                int success = payDao.updateByPrimaryKeySelective(updatePayMoneyReqBO);
                if(success ==0){
                    logger.error("更新记录服务失败啦");
                }

                return  success;
            }catch(Exception e){
                logger.error("缴费服务失败啦", e);
                throw new RuntimeException();
            }
        }
    }
    //********************根据姓名、身份证号和缴费类型查询缴费表********************************************************************
    @Override
    public Pay selectPayInfo(QryPayReqBO qryPayReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询缴费服务入参{}" + qryPayReqBO.toString());
        }
        return payDao.selectPayInfo(qryPayReqBO);
    }

}
