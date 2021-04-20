package org.edu.dao;

import org.edu.bo.employee.EditEmployeeReqBO;
import org.edu.bo.owner.AddOwnerReqBO;
import org.edu.bo.owner.EditOwnerReqBO;
import org.edu.bo.owner.QryOwnerReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Owner;

import java.util.List;
import java.util.Map;

public interface OwnerDao {
    //删除业主
    int deleteByPrimaryKey(Long ownerId);
    //添加业主
    int insertSelective(AddOwnerReqBO record);
    //查询业主是否存在
    Owner selectOwnerIsExist(Map<String, Object> params);
    //编辑业主
    Owner selectByPrimaryKey(Long ownerId);
    int updateByPrimaryKeySelective(EditOwnerReqBO record);

    //查询业主列表
    List<Owner> selectToOwner(QryOwnerReqBO qryOwnerReqBO, Page<Owner> page);

    int insert(Owner record);
    int updateByPrimaryKey(Owner record);
}