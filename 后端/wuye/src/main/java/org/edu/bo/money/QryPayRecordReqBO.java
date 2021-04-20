package org.edu.bo.money;

import org.edu.common.page.BO.ReqPageBO;

/**
 * 标题:查询缴费记录
 */
public class QryPayRecordReqBO extends ReqPageBO {
    private String payCordName;
    private String idCard;

    public String getPayCordName() {
        return payCordName;
    }

    public void setPayCordName(String payCordName) {
        this.payCordName = payCordName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "QryPayRecordReqBO{" +
                "payCordName='" + payCordName + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
