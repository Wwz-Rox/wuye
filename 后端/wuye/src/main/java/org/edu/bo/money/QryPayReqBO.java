package org.edu.bo.money;

/**
 * 标题:根据姓名和身份证号查缴费表
 */
public class QryPayReqBO {

    private String payname;
    private String paycard;
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

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public String getPaycard() {
        return paycard;
    }

    public void setPaycard(String paycard) {
        this.paycard = paycard;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    @Override
    public String toString() {
        return "QryPayReqBO{" +
                "payname='" + payname + '\'' +
                ", paycard='" + paycard + '\'' +
                ", paytype='" + paytype + '\'' +
                ", paybuild='" + paybuild + '\'' +
                ", payunit='" + payunit + '\'' +
                ", payhouse='" + payhouse + '\'' +
                '}';
    }
}
