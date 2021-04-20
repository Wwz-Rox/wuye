package org.edu.service.impl;

import org.edu.bo.equipmentRepair.AddEquipmentRepairReqBO;
import org.edu.bo.equipmentRepair.QryEquipmentRepairReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.EquipmentRepairDao;
import org.edu.model.EquipmentRepair;
import org.edu.service.EquipmentRepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标题:设备报修模块实现类
 */
@Service
public class EquipmentRepairServiceImpl implements EquipmentRepairService {
    private final static Logger logger = LoggerFactory.getLogger(EquipmentRepairServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private EquipmentRepairDao equipmentRepairDao;
    //******************************删除设备报修********************************************************************
    @Override
    public int deleteEquipmentRepair(Long equRepairId) {
        if (isDebugEnabled) {
            logger.debug("删除设备报修服务入参{}" + equRepairId);
        }
        return equipmentRepairDao.deleteByPrimaryKey(equRepairId);
    }
    //******************************更新状态********************************************************************
    @Override
    public int updateEquipmentRepair(Long equRepairId) {
        if (isDebugEnabled) {
            logger.debug("更新状态服务入参{}" + equRepairId);
        }
        int result=equipmentRepairDao.updateByPrimaryKey(equRepairId);
        int issuccess=equipmentRepairDao.insertRecord(equRepairId);
        if(issuccess >0){
//            logger.debug("插入记录表成功1111");
            if (isDebugEnabled) {
                logger.debug("插入记录表成功");
            }
        }else{
//            logger.debug("插入记录表失败1111");
            if (isDebugEnabled) {
                logger.debug("插入记录表失败");
            }
        }
        return result;
    }
//    //******************************插入记录表********************************************************************
//    public int insertRecord() {
//        if (isDebugEnabled) {
//            logger.debug("更新状态服务入参{}" + equRepairId);
//        }
//        equipmentRepairDao.insertRecord();
//
//        int result=      equipmentRepairDao.updateByPrimaryKey(equRepairId);
//        return result;
//    }
    //******************************查询设备报修********************************************************************
    @Override
    public RspPageBO<EquipmentRepair> qryEquipmentRepair(QryEquipmentRepairReqBO qryEquipmentRepairReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询设备报修服务入参{}" + qryEquipmentRepairReqBO.toString());
        }
        RspPageBO<EquipmentRepair> rspPageBO = new RspPageBO<EquipmentRepair>();
        try{
            Page<EquipmentRepair> page = new Page<EquipmentRepair>(qryEquipmentRepairReqBO.getPageNo(),qryEquipmentRepairReqBO.getPageSize());
            List<EquipmentRepair> list=equipmentRepairDao.selectEquipmentRepair(qryEquipmentRepairReqBO,page);
            rspPageBO.setRows(list);
            rspPageBO.setPageNo(qryEquipmentRepairReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询设备报修服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************添加设备报修********************************************************************
    @Override
    public int addEquipmentRepair(AddEquipmentRepairReqBO addEquipmentRepairReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加设备报修服务入参{}" + addEquipmentRepairReqBO.toString());
        }
        EquipmentRepair equipmentRepair=equipmentRepairDao.selectIsRepair(addEquipmentRepairReqBO.getEquRepairName());
        if (null == equipmentRepair) {
            return equipmentRepairDao.insertSelective(addEquipmentRepairReqBO);
        }else{
            return -1;
        }

    }
}

