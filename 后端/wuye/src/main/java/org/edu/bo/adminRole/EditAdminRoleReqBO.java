package org.edu.bo.adminRole;

public class EditAdminRoleReqBO {
    private String adminRoleName;
    private String adminRoleList;
    private String adminRoleDesc;
    private Integer adminRoleId;

    public String getAdminRoleName() {
        return adminRoleName;
    }

    public void setAdminRoleName(String adminRoleName) {
        this.adminRoleName = adminRoleName;
    }

    public String getAdminRoleList() {
        return adminRoleList;
    }

    public void setAdminRoleList(String adminRoleList) {
        this.adminRoleList = adminRoleList;
    }

    public String getAdminRoleDesc() {
        return adminRoleDesc;
    }

    public void setAdminRoleDesc(String adminRoleDesc) {
        this.adminRoleDesc = adminRoleDesc;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    @Override
    public String toString() {
        return "EditAdminRoleReqBO{" +
                "adminRoleName='" + adminRoleName + '\'' +
                ", adminRoleList='" + adminRoleList + '\'' +
                ", adminRoleDesc='" + adminRoleDesc + '\'' +
                ", adminRoleId=" + adminRoleId +
                '}';
    }
}
