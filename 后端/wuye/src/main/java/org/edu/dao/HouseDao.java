package org.edu.dao;

import org.edu.bo.house.AddHouseReqBO;
import org.edu.bo.house.EditHouseReqBO;
import org.edu.bo.house.QryHouseReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.House;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HouseDao {
    //删除房屋
    int deleteByPrimaryKey(Long houseId);
    //添加房屋
    int insertSelective(AddHouseReqBO record);
    //编辑房屋
    House selectByPrimaryKey(Long houseId);
    int updateByPrimaryKeySelective(EditHouseReqBO record);

    //查询房屋列表
    List<House> selectToHouse(QryHouseReqBO QryHouseReqBO, Page<House>page);
    //查询房屋是否存在
    House selectHouseIsExist(Map<String, Object> params);



    int updateByPrimaryKey(House record);
    int insert(House record);
}