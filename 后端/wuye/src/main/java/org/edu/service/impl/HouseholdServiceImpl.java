package org.edu.service.impl;

import org.edu.bo.household.AddHouseholdReqBO;
import org.edu.bo.household.EditHouseholdReqBO;
import org.edu.bo.household.QryHouseholdReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.HouseholdDao;
import org.edu.model.Household;
import org.edu.service.HouseholdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题:租户模块
 */
@Service
public class HouseholdServiceImpl implements HouseholdService {
    private final static Logger logger = LoggerFactory.getLogger(HouseholdServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private HouseholdDao householdDao;
    //******************************查询租户********************************************************************
    @Override
    public RspPageBO<Household> QryHousehold(QryHouseholdReqBO qryHouseholdReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询租户列表服务入参{}" + qryHouseholdReqBO.toString());
        }
        RspPageBO<Household> rspPageBO = new RspPageBO<Household>();
        try{
            Page<Household> page = new Page<Household>(qryHouseholdReqBO.getPageNo(),qryHouseholdReqBO.getPageSize());
            List<Household> adminList=householdDao.selectToHousehold(qryHouseholdReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryHouseholdReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询租户列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除租户********************************************************************
    @Override
    public int deleteHousehold(Long householdId) {
        if (isDebugEnabled) {
            logger.debug("删除租户列表服务入参{}" + householdId);
        }
        return householdDao.deleteByPrimaryKey(householdId);
    }
    //******************************添加租户********************************************************************
    @Override
    public int addHousehold(AddHouseholdReqBO addHouseholdReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加租户列表服务入参{}" + addHouseholdReqBO.toString());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("householdName", addHouseholdReqBO.getHouseholdName());
        params.put("householdCardid", addHouseholdReqBO.getHouseholdCardid());
        Household household=householdDao.selectIsExist(params);
        if(null == household){
            return householdDao.insertSelective(addHouseholdReqBO);
        }else{
            return -1;
        }

    }
    //******************************编辑租户********************************************************************
    @Override
    public Household selectHousehold(Long householdId) {
        if (isDebugEnabled) {
            logger.debug("编辑-查询租户列表服务入参{}" + householdId);
        }
        return householdDao.selectByPrimaryKey(householdId);
    }

    @Override
    public int updateHousehold(EditHouseholdReqBO editHouseholdReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑租户列表服务入参{}" + editHouseholdReqBO.toString());
        }
        return householdDao.updateByPrimaryKeySelective(editHouseholdReqBO);
    }
}
