package org.edu.service.impl;

import org.edu.bo.admin.*;
import org.edu.common.page.mybatis.Page;
import org.edu.common.page.BO.RspPageBO;
import org.edu.dao.AdminDao;
import org.edu.model.Admin;
import org.edu.service.AdminService;
import org.edu.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 标题:管理员模块实现类
 */
@Service
public class AdminServiceImpl implements AdminService {
    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private AdminDao adminDao;

    @Override
    public void updateDemo(String name, String password, Admin admin) {
        System.out.println("姓名"+name);
        System.out.println("密码"+password);
        System.out.println("管理员"+admin);
    }
    //******************************管理员登陆********************************************************************
    @Override
    public Admin adminLogin(AdminLoginReqBO adminLoginReqBO) {
        if (isDebugEnabled) {
            logger.debug("管理员登陆服务入参{}" + adminLoginReqBO.toString());
        }
        System.out.println("管理员名称"+adminLoginReqBO.getAdminName());
        System.out.println("管理员密码"+adminLoginReqBO.getAdminPassword());
        try {
            String miyue=MD5Utils.md5(adminLoginReqBO.getAdminPassword());
            adminLoginReqBO.setAdminPassword(miyue);


            Admin admin = adminDao.selectAdmin(adminLoginReqBO);
            if(admin !=null){
                if(admin.getStatus().equals("已启用")){
                    String mingwen=admin.getAdminPassword();
                    if(miyue.equals(mingwen)){
                        int result=adminDao.insertRe(adminLoginReqBO);//插入记录
                        if(result==0){
                            logger.error("插入记录服务失败啦");
                        }
                        return admin;
                    }else{
                        logger.error("加密密码不一致，登陆失败");
                        return null;
                    }
                }else{
//                logger.error("管理员状态出错");
                    return admin;
                }
            }else{
                return admin;
            }

        }catch(Exception e){
            logger.error("管理员登陆服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************查询管理员********************************************************************
    @Override
    public RspPageBO<Admin> QryAdmin(QryAdminReqBO qryAdminReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询管理员列表服务入参{}" + qryAdminReqBO.toString());
        }
//        System.out.println("进入查询管理员列表实现类impl");
        RspPageBO<Admin> rspPageBO = new RspPageBO<Admin>();
        try{
            Page<Admin> page = new Page<Admin>(qryAdminReqBO.getPageNo(),qryAdminReqBO.getPageSize());
            List<Admin> adminList=adminDao.selectAdminList(qryAdminReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryAdminReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询管理员列表服务失败啦", e);
            throw new RuntimeException();
        }

    }
    //***********************删除管理员**********************************************************
    @Override
    public int deleteAdmin(Integer adminId) {
        if (isDebugEnabled) {
            logger.debug("删除管理员服务入参{}" + adminId);
        }
        try {
            System.out.println("进入删除管理员服务实现类impl");
        int result=adminDao.deleteByPrimaryKey(adminId);
        if(result==0){
            logger.error("删除管理员服务失败啦");
        }
            return result;
        }catch(Exception e){
                logger.error("删除管理员服务失败啦", e);
                throw new RuntimeException();
            }


    }
    //***********************添加管理员**********************************************************
    @Override
    public int addAdmin(AddAdminReqBO addAdminReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加管理员服务入参{}" + addAdminReqBO.toString());
        }
        if(!StringUtils.isEmpty(addAdminReqBO.getAdminPassword())){
            String miyue= MD5Utils.md5(addAdminReqBO.getAdminPassword());
            addAdminReqBO.setAdminPassword(miyue);
        }
        try{
        //查询管理员是否存在
        Admin admin =adminDao.selectIsExist(addAdminReqBO.getAdminName());
        if(null == admin){
            return adminDao.insertSelective(addAdminReqBO);
        }else{
            logger.debug("管理员已存在");
            return -1;
        }

    }catch(Exception e){
        logger.error("添加管理员service失败啦", e);
        throw new RuntimeException();
    }

    }
    //***********************编辑管理员**********************************************************
    @Override
    public Admin selectAdmin(Integer adminId) {
        if (isDebugEnabled) {
            logger.debug("编辑管理员服务入参管理员ID{}" + adminId.toString());
        }
        return adminDao.selectOneAdmin(adminId);
    }

    @Override
    public int updateAdmin(EditAdminReqBO editAdminReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑管理员服务入参{}" + editAdminReqBO.toString());
        }
        String miyue=MD5Utils.md5(editAdminReqBO.getAdminPassword());
        editAdminReqBO.setAdminPassword(miyue);
        return adminDao.updateByPrimaryKeySelective(editAdminReqBO);
    }
    //***************************修改密码******************************************************
    @Override
    public int updatePass(UpdateAdminPassReqBO updateAdminPassReqBO) {
        if (isDebugEnabled) {
            logger.debug("修改密码服务入参{}" + updateAdminPassReqBO.toString());
        }
        String miyue=MD5Utils.md5(updateAdminPassReqBO.getAdminPassword());
        updateAdminPassReqBO.setAdminPassword(miyue);
        return adminDao.updateAdminPass(updateAdminPassReqBO);
    }
    //**************************个人信息******************************************************
    @Override
    public Admin PersonInfo(String adminName) {
        if (isDebugEnabled) {
            logger.debug("个人信息服务入参{}" + adminName);
        }
        return adminDao.selectInfo(adminName);
    }
    //**************************更新状态******************************************************
    @Override
    public int updateStatus(Integer adminId) {
        if (isDebugEnabled) {
            logger.debug("更新状态服务入参{}" + adminId);
        }
        Admin ad=adminDao.selectByPrimaryKey(adminId);
        if(ad.getStatus().equals("已启用")){
            int success=adminDao.updateAdminStatusNot(adminId);
            return success;
        }else{
            int success=adminDao.updateAdminStatus(adminId);
            return success;
        }

    }

}
