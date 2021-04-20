package org.edu.bo.house;

import org.edu.common.page.BO.ReqPageBO;

/**
 * 标题:查询房屋列表
 */
public class QryHouseReqBO extends ReqPageBO {
    private String houseType;

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Override
    public String toString() {
        return "QryHouseReqBO{" +
                "houseType='" + houseType + '\'' +
                '}';
    }
}
