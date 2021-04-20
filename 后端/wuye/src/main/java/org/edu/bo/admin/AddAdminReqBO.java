package org.edu.bo.admin;

/**
 * 标题:添加管理员
 */
public class AddAdminReqBO {

    private String adminName;
    private String adminPassword;
    private String adminRole;
    private String telphone;
    private String eMail;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "AddAdminReqBO{" +
                "adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", AdminRole='" + adminRole + '\'' +
                ", telphone='" + telphone + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
