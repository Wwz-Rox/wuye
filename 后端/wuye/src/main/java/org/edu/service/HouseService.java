package org.edu.service;

import org.edu.bo.house.AddHouseReqBO;
import org.edu.bo.house.EditHouseReqBO;
import org.edu.bo.house.QryHouseReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.House;

/**
 * 标题:房屋模块
 */
public interface HouseService {
    //查询房屋
    RspPageBO<House> QryHouse(QryHouseReqBO qryAdminReqBO);
    //删除房屋
    int deleteHouse(Long employeeId);
    //添加房屋
    int addHouse(AddHouseReqBO addAdminReqBO);
    //编辑房屋
    House selectHouse(Long employeeId);
    int updateHouse(EditHouseReqBO editAdminReqBO);
}
