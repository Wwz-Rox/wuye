package org.edu.service.impl;

import org.edu.bo.adminRole.AddAdminRoleReqBO;
import org.edu.bo.adminRole.EditAdminRoleReqBO;
import org.edu.bo.adminRole.QryAdminRoleReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.AdminDao;
import org.edu.dao.AdminRoleDao;
import org.edu.model.AdminRole;
import org.edu.service.AdminRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    private final static Logger logger = LoggerFactory.getLogger(AdminRoleServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private AdminRoleDao adminRoleDao;
    @Autowired
    private AdminDao adminDao;
    //******************************查询管理员角色********************************************************************
    @Override
    public RspPageBO<AdminRole> QryAdminRole(QryAdminRoleReqBO qryAdminReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询管理员角色服务入参{}" + qryAdminReqBO.toString());
        }
        RspPageBO<AdminRole> rspPageBO = new RspPageBO<AdminRole>();
        try{
            Page<AdminRole> page = new Page<AdminRole>(qryAdminReqBO.getPageNo(),qryAdminReqBO.getPageSize());
            List<AdminRole> adminList=adminRoleDao.selectAdminRole(qryAdminReqBO,page);
//            for(AdminRole adminRole :adminList){
//                List<String> nameList=adminDao.selectAdminName(qryAdminReqBO.getAdminRoleName());
//                String name ="";
//                for(String n : nameList){
//                    name = name +n+"  ,  ";
//                }
//                adminRole.setAdminRoleList(name);
//            }
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryAdminReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询管理员角色服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除管理员角色********************************************************************
    @Override
    public int deleteAdminRole(Integer adminRoleId) {
        if (isDebugEnabled) {
            logger.debug("删除管理员角色服务入参{}" + adminRoleId);
        }
        return adminRoleDao.deleteByPrimaryKey(adminRoleId);
    }
    //******************************添加管理员角色********************************************************************
    @Override
    public int addAdminRole(AddAdminRoleReqBO addAdminReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加管理员角色服务入参{}" + addAdminReqBO.toString());
        }

        List<String> nameList=adminDao.selectAdminName(addAdminReqBO.getAdminRoleName());
        String name ="";
        int i=0;
        for(String n : nameList){
            i++;
            if(i == nameList.size() ){
                name = name +n+"";
            }else {
                name = name +n+"  , ";
            }
        }
        AdminRole adminROle =adminRoleDao.selectRoleIsExist(addAdminReqBO.getAdminRoleName());
        if(null == adminROle){
            addAdminReqBO.setAdminRoleList(name);
            return adminRoleDao.insertAdminRole(addAdminReqBO);
        }else{
            return -1;
        }

    }
    //***********************编辑管理员角色**********************************************************
    @Override
    public AdminRole selectAdminRole(Integer adminId) {
        if (isDebugEnabled) {
            logger.debug("添加管理员角色服务入参{}" + adminId);
        }
        return adminRoleDao.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateAdminRole(EditAdminRoleReqBO editAdminReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加管理员角色服务入参{}" + editAdminReqBO.toString());
        }
        return adminRoleDao.updateByPrimaryKeySelective(editAdminReqBO);
    }
}
