package org.edu.service.impl;

import org.edu.bo.house.AddHouseReqBO;
import org.edu.bo.house.EditHouseReqBO;
import org.edu.bo.house.QryHouseReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.HouseDao;
import org.edu.model.House;
import org.edu.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题:房屋模块
 */
@Service
public class HouseServiceImpl implements HouseService {
    private final static Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private HouseDao houseDao;
    //******************************查询房屋********************************************************************
    @Override
    public RspPageBO<House> QryHouse(QryHouseReqBO qryHouseReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询房屋列表服务入参{}" + qryHouseReqBO.toString());
        }
        RspPageBO<House> rspPageBO = new RspPageBO<House>();
        try{
            Page<House> page = new Page<House>(qryHouseReqBO.getPageNo(),qryHouseReqBO.getPageSize());
            List<House> adminList=houseDao.selectToHouse(qryHouseReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryHouseReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询房屋列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除房屋********************************************************************
    @Override
    public int deleteHouse(Long houseId) {
        if (isDebugEnabled) {
            logger.debug("删除房屋服务入参{}" + houseId);
        }
        return houseDao.deleteByPrimaryKey(houseId);
    }
    //******************************添加房屋********************************************************************
    @Override
    public int addHouse(AddHouseReqBO addHouseReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加房屋服务入参{}" + addHouseReqBO.toString());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("buildingNumber", addHouseReqBO.getBuildingNumber());
        params.put("unitNumber", addHouseReqBO.getUnitNumber());
        params.put("houseNumber", addHouseReqBO.getHouseNumber());
        House house=houseDao.selectHouseIsExist(params);
        if (null == house) {
            return houseDao.insertSelective(addHouseReqBO);
        }else{
            return -1;
        }

    }
    //******************************编辑房屋********************************************************************
    @Override
    public House selectHouse(Long houseId) {
        if (isDebugEnabled) {
            logger.debug("编辑-查询房屋服务入参{}" + houseId);
        }
        return houseDao.selectByPrimaryKey(houseId);
    }

    @Override
    public int updateHouse(EditHouseReqBO editHouseReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑房屋服务入参{}" + editHouseReqBO.toString());
        }
        return houseDao.updateByPrimaryKeySelective(editHouseReqBO);
    }
}
