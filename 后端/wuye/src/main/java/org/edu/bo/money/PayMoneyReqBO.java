package org.edu.bo.money;

/**
 * 标题:缴费模块入参
 */
public class PayMoneyReqBO {

    private String payName;

    private String payTel;

    private String payBuildNum;

    private String payUnitNum;

    private String payHouseNum;

    private String payType;

    private String idCard;

    private Long payMoney;

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayTel() {
        return payTel;
    }

    public void setPayTel(String payTel) {
        this.payTel = payTel;
    }

    public String getPayBuildNum() {
        return payBuildNum;
    }

    public void setPayBuildNum(String payBuildNum) {
        this.payBuildNum = payBuildNum;
    }

    public String getPayUnitNum() {
        return payUnitNum;
    }

    public void setPayUnitNum(String payUnitNum) {
        this.payUnitNum = payUnitNum;
    }

    public String getPayHouseNum() {
        return payHouseNum;
    }

    public void setPayHouseNum(String payHouseNum) {
        this.payHouseNum = payHouseNum;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoneyNum) {
        this.payMoney = payMoneyNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "PayMoneyReqBO{" +
                "payName='" + payName + '\'' +
                ", payTel='" + payTel + '\'' +
                ", payBuildNum='" + payBuildNum + '\'' +
                ", payUnitNum='" + payUnitNum + '\'' +
                ", payHouseNum='" + payHouseNum + '\'' +
                ", payType='" + payType + '\'' +
                ", idCard='" + idCard + '\'' +
                ", payMoney=" + payMoney +
                '}';
    }
}
