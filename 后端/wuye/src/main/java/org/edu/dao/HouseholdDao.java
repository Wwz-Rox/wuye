package org.edu.dao;

import org.edu.bo.household.AddHouseholdReqBO;
import org.edu.bo.household.EditHouseholdReqBO;
import org.edu.bo.household.QryHouseholdReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Household;

import java.util.List;
import java.util.Map;

public interface HouseholdDao {
    //删除租户
    int deleteByPrimaryKey(Long householdId);

    //添加租户
    int insertSelective(AddHouseholdReqBO record);
    //编辑租户
    Household selectByPrimaryKey(Long householdId);
    int updateByPrimaryKeySelective(EditHouseholdReqBO record);

    //查询租户列表
    List<Household> selectToHousehold(QryHouseholdReqBO qryHouseholdReqBO, Page<Household> page);
    //查询租户是否存在
    Household selectIsExist(Map<String,Object>params);

    int updateByPrimaryKey(Household record);
    int insert(Household record);
}