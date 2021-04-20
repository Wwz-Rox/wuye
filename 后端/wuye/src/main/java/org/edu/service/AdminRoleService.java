package org.edu.service;

import org.edu.bo.adminRole.AddAdminRoleReqBO;
import org.edu.bo.adminRole.EditAdminRoleReqBO;
import org.edu.bo.adminRole.QryAdminRoleReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.AdminRole;


public interface AdminRoleService {
    //查询管理员角色
    RspPageBO<AdminRole> QryAdminRole(QryAdminRoleReqBO qryAdminReqBO);
    //删除管理员角色
    int deleteAdminRole(Integer adminRoleId);
    //添加管理员角色
    int addAdminRole(AddAdminRoleReqBO addAdminReqBO);
    //编辑管理员角色
    AdminRole selectAdminRole(Integer adminRoleId);
    int updateAdminRole(EditAdminRoleReqBO editAdminReqBO);
}
