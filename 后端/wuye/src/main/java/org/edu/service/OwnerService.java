package org.edu.service;

import org.edu.bo.owner.AddOwnerReqBO;
import org.edu.bo.owner.EditOwnerReqBO;
import org.edu.bo.owner.QryOwnerReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Owner;

/**
 * 标题:业主模块
 */
public interface OwnerService {
    //查询员工
    RspPageBO<Owner> QryOwner(QryOwnerReqBO qryAdminReqBO);
    //删除员工
    int deleteOwner(Long ownerId);
    //添加员工
    int addOwner(AddOwnerReqBO addAdminReqBO);
    //编辑员工
    Owner selectOwner(Long ownerId);
    int updateOwner(EditOwnerReqBO editAdminReqBO);
}
