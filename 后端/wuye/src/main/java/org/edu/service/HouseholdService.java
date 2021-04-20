package org.edu.service;

import org.edu.bo.household.AddHouseholdReqBO;
import org.edu.bo.household.EditHouseholdReqBO;
import org.edu.bo.household.QryHouseholdReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Household;

/**
 * 标题:租户模块
 */
public interface HouseholdService {
    //查询租户
    RspPageBO<Household> QryHousehold(QryHouseholdReqBO qryAdminReqBO);
    //删除租户
    int deleteHousehold(Long householdId);
    //添加租户
    int addHousehold(AddHouseholdReqBO addAdminReqBO);
    //编辑租户
    Household selectHousehold(Long householdId);
    int updateHousehold(EditHouseholdReqBO editAdminReqBO);

}
