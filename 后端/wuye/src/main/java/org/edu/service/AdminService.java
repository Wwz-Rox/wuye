package org.edu.service;

import org.edu.bo.admin.*;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Admin;

/**
 * 标题:管理员模块Service层
 */
public interface AdminService {
    //void demo();
    void updateDemo(String name ,String password ,Admin admin);

    //管理员登陆
    Admin adminLogin(AdminLoginReqBO adminLoginReqBO);
    //Admin adminLogin(@Param("name")String name, @Param("password")String password);
    //查询管理员
    RspPageBO<Admin> QryAdmin(QryAdminReqBO qryAdminReqBO);
    //删除管理员
    int deleteAdmin(Integer adminId);
    //添加管理员
    int addAdmin(AddAdminReqBO addAdminReqBO);
    //编辑管理员
    Admin selectAdmin(Integer adminId);
    int updateAdmin(EditAdminReqBO editAdminReqBO);
    //修改密码
    int updatePass(UpdateAdminPassReqBO updateAdminPassReqBO);
    //个人信息
    Admin PersonInfo(String adminName);
    //更新状态
    int updateStatus(Integer adminId);
}
