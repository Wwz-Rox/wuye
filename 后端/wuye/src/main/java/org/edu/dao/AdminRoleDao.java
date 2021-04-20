package org.edu.dao;

import org.edu.bo.adminRole.AddAdminRoleReqBO;
import org.edu.bo.adminRole.EditAdminRoleReqBO;
import org.edu.bo.adminRole.QryAdminRoleReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.AdminRole;

import java.util.List;

public interface AdminRoleDao {
    //查询管理员角色是否存在
    AdminRole selectRoleIsExist(String adminRole);
    //删除管理员角色
    int deleteByPrimaryKey(Integer adminRoleId);
    //添加管理员角色
    int insertAdminRole(AddAdminRoleReqBO record);
    //编辑管理员角色
    AdminRole selectByPrimaryKey(Integer houseId);
    int updateByPrimaryKeySelective(EditAdminRoleReqBO record);
    //查询管理员角色
    List<AdminRole> selectAdminRole(QryAdminRoleReqBO QryHouseReqBO, Page<AdminRole> page);

    int insertSelective(AdminRole record);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}