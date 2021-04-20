package org.edu.service.impl;

import org.edu.bo.repairPerson.AddRepairPersonReqBO;
import org.edu.bo.repairPerson.EditRepairPersonReqBO;
import org.edu.bo.repairPerson.QryRepairPersonReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.RepairPersonDao;
import org.edu.model.Owner;
import org.edu.model.RepairPerson;
import org.edu.service.RepairPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题:维修人员模块实现类
 */
@Service
public class RepairPersonServiceImpl implements RepairPersonService {
    private final static Logger logger = LoggerFactory.getLogger(RepairPersonServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private RepairPersonDao repairPersonDao;
    //******************************查询维修人员********************************************************************
    @Override
    public RspPageBO<RepairPerson> qryRepairPerson(QryRepairPersonReqBO qryRepairPersonReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询维修人员服务入参{}" + qryRepairPersonReqBO.toString());
        }
        RspPageBO<RepairPerson> rspPageBO = new RspPageBO<RepairPerson>();
        try{
            Page<RepairPerson> page = new Page<RepairPerson>(qryRepairPersonReqBO.getPageNo(),qryRepairPersonReqBO.getPageSize());
            List<RepairPerson> list=repairPersonDao.selectRepairPerson(qryRepairPersonReqBO,page);
            rspPageBO.setRows(list);
            rspPageBO.setPageNo(qryRepairPersonReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询维修人员服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************添加维修人员********************************************************************
    @Override
    public int addRepairPerson(AddRepairPersonReqBO addRepairPersonReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加维修人员服务入参{}" + addRepairPersonReqBO.toString());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("repairName", addRepairPersonReqBO.getRepairName());
        params.put("repairNum", addRepairPersonReqBO.getRepairNum());
        RepairPerson repairPerson=repairPersonDao.selectPersonIsExist(params);
        if(null == repairPerson){
            //equ_repair_id入值
            repairPersonDao.updateEqurepairid();
            int  a=(int)(Math.random()*90000+10000);
            char str= (char)(Math.random ()*26+'A');
            String  code =String.valueOf(str)+a;
            addRepairPersonReqBO.setRepairNum(code);
            return repairPersonDao.insertSelective(addRepairPersonReqBO);
        }else{
            return -1;
        }
    }
    //******************************删除维修人员********************************************************************
    @Override
    public int deleteRepairPerson(Integer repairId) {
        if (isDebugEnabled) {
            logger.debug("删除维修人员服务入参{}" + repairId);
        }
        return repairPersonDao.deleteByPrimaryKey(repairId);
    }
    //******************************编辑维修人员********************************************************************
    @Override
    public RepairPerson selectRepairPerson(Integer repairId) {
        if (isDebugEnabled) {
            logger.debug("编辑维修人员服务入参{}" + repairId);
        }
        return repairPersonDao.selectByPrimaryKey(repairId);
    }

    @Override
    public int updateRepairPerson(EditRepairPersonReqBO editRepairPersonReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑维修人员服务2入参{}" + editRepairPersonReqBO.toString());
        }
        return repairPersonDao.updateByPrimaryKeySelective(editRepairPersonReqBO);
    }
}
