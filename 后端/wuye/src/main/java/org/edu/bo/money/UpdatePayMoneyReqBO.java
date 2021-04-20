package org.edu.bo.money;
public class UpdatePayMoneyReqBO {
    private String payName;

    private String idCard;

    private Long payMoney;

    private String paytype;

    private String paybuild;
    private String payunit;
    private String payhouse;

    public String getPaybuild() {
        return paybuild;
    }

    public void setPaybuild(String paybuild) {
        this.paybuild = paybuild;
    }

    public String getPayunit() {
        return payunit;
    }

    public void setPayunit(String payunit) {
        this.payunit = payunit;
    }

    public String getPayhouse() {
        return payhouse;
    }

    public void setPayhouse(String payhouse) {
        this.payhouse = payhouse;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    @Override
    public String toString() {
        return "UpdatePayMoneyReqBO{" +
                "payName='" + payName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", payMoney=" + payMoney +
                ", paytype='" + paytype + '\'' +
                ", paybuild='" + paybuild + '\'' +
                ", payunit='" + payunit + '\'' +
                ", payhouse='" + payhouse + '\'' +
                '}';
    }
}
