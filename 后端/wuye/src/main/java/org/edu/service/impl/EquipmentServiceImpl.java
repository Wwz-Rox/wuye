package org.edu.service.impl;

import org.edu.bo.equipment.AddEquipmentReqBO;
import org.edu.bo.equipment.EditEquipmentReqBO;
import org.edu.bo.equipment.QryEquipmentReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.EquipmentDao;
import org.edu.model.Equipment;
import org.edu.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标题:设备模块
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final static Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private EquipmentDao equipmentDao;
    //******************************查询设备********************************************************************
    @Override
    public RspPageBO<Equipment> qryEquipment(QryEquipmentReqBO qryEquipmentReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询设备服务入参{}" + qryEquipmentReqBO.toString());
        }
        RspPageBO<Equipment> rspPageBO = new RspPageBO<Equipment>();
        try{
            Page<Equipment> page = new Page<Equipment>(qryEquipmentReqBO.getPageNo(),qryEquipmentReqBO.getPageSize());
            List<Equipment> EquipmentList=equipmentDao.selecttoEquipment(qryEquipmentReqBO,page);
            rspPageBO.setRows(EquipmentList);
            rspPageBO.setPageNo(qryEquipmentReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询设备列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************添加设备********************************************************************
    @Override
    public int addEquipment(AddEquipmentReqBO addEquipmentReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加设备服务入参{}" + addEquipmentReqBO.toString());
        }
        Equipment equipment=equipmentDao.selectEquipmentIsExist(addEquipmentReqBO.getEquipmentName());
        if (null == equipment) {
            return equipmentDao.insertEquipment(addEquipmentReqBO);
        }else{
            return -1;
        }

    }
    //******************************删除设备********************************************************************
    @Override
    public int deleteEquipment(Long equipmentId) {
        if (isDebugEnabled) {
            logger.debug("删除设备服务入参{}" + equipmentId);
        }
        return equipmentDao.deleteByPrimaryKey(equipmentId);
    }
    //******************************编辑设备********************************************************************
    @Override
    public Equipment selectEquipment(Long equipmentId) {
        if (isDebugEnabled) {
            logger.debug("编辑设备-查询单个服务入参{}" + equipmentId);
        }
        return equipmentDao.selectByPrimaryKey(equipmentId);
    }

    @Override
    public int updateEquipment(EditEquipmentReqBO editEquipmentReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加设备服务入参{}" + editEquipmentReqBO.toString());
        }
        return equipmentDao.updateByPrimaryKeySelective(editEquipmentReqBO);
    }
}
