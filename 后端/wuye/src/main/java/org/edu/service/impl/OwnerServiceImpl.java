package org.edu.service.impl;

import org.edu.bo.owner.AddOwnerReqBO;
import org.edu.bo.owner.EditOwnerReqBO;
import org.edu.bo.owner.QryOwnerReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.OwnerDao;
import org.edu.model.Household;
import org.edu.model.Owner;
import org.edu.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题:业主模块
 */
@Service
public class OwnerServiceImpl implements OwnerService {
    private final static Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private OwnerDao ownerDao;
    //******************************查询业主********************************************************************
    @Override
    public RspPageBO<Owner> QryOwner(QryOwnerReqBO qryOwnerReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询业主列表服务入参{}" + qryOwnerReqBO.toString());
        }
        RspPageBO<Owner> rspPageBO = new RspPageBO<Owner>();
        try{
            Page<Owner> page = new Page<Owner>(qryOwnerReqBO.getPageNo(),qryOwnerReqBO.getPageSize());
            List<Owner> adminList=ownerDao.selectToOwner(qryOwnerReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryOwnerReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询业主列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除业主********************************************************************
    @Override
    public int deleteOwner(Long ownerId) {
        if (isDebugEnabled) {
            logger.debug("删除业主服务入参{}" + ownerId);
        }
        return ownerDao.deleteByPrimaryKey(ownerId);
    }
    //******************************添加业主********************************************************************
    @Override
    public int addOwner(AddOwnerReqBO addOwnerReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加业主服务入参{}" + addOwnerReqBO.toString());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ownerName", addOwnerReqBO.getOwnerName());
        params.put("ownerCardid", addOwnerReqBO.getOwnerCardid());
        Owner owner=ownerDao.selectOwnerIsExist(params);
        if(null == owner){
            return ownerDao.insertSelective(addOwnerReqBO);
        }else{
            return -1;
        }
    }
    //******************************编辑业主********************************************************************
    @Override
    public Owner selectOwner(Long ownerId) {
        if (isDebugEnabled) {
            logger.debug("编辑-查看业主服务入参{}" + ownerId);
        }
        return ownerDao.selectByPrimaryKey(ownerId);
    }

    @Override
    public int updateOwner(EditOwnerReqBO editOwnerReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑业主服务入参{}" + editOwnerReqBO.toString());
        }
        return ownerDao.updateByPrimaryKeySelective(editOwnerReqBO);
    }
}
