package org.edu.dao;

import org.edu.bo.admin.*;
import org.edu.bo.adminRole.AddAdminRoleReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(AddAdminReqBO record);
    //更新状态
    Admin selectByPrimaryKey(Integer adminId);
    int updateAdminStatusNot(Integer adminId);
    int updateAdminStatus(Integer adminId);

    int updateByPrimaryKey(Admin record);
    //管理员编辑
    int updateByPrimaryKeySelective(EditAdminReqBO editAdminReqBO);
    Admin selectOneAdmin(Integer adminId);
    //管理员登陆
    Admin selectAdmin(AdminLoginReqBO adminLoginReqBO);
    //Admin selectAdmin(@Param("name")String name, @Param("password")String password);

    //查询管理员
    List<Admin> selectAdminList(QryAdminReqBO qryAdminReqBO, Page<Admin> page);
    //修改密码
    int updateAdminPass(UpdateAdminPassReqBO updateAdminPassReqBO);
    //个人信息
    Admin selectInfo(String adminName);

    //插入记录
    int insertRe(AdminLoginReqBO adminLoginReqBO);

    //查询管理员角色
    List<String> selectAdminName(String adminRoleName);
    //查询管理员是否存在
    Admin selectIsExist(String adminName);
}