package org.edu.model;

public class AdminRole {
    private Integer adminRoleId;

    private String adminRoleName;

    private String adminRoleList;

    private String adminRoleDesc;

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getAdminRoleName() {
        return adminRoleName;
    }

    public void setAdminRoleName(String adminRoleName) {
        this.adminRoleName = adminRoleName == null ? null : adminRoleName.trim();
    }

    public String getAdminRoleList() {
        return adminRoleList;
    }

    public void setAdminRoleList(String adminRoleList) {
        this.adminRoleList = adminRoleList == null ? null : adminRoleList.trim();
    }

    public String getAdminRoleDesc() {
        return adminRoleDesc;
    }

    public void setAdminRoleDesc(String adminRoleDesc) {
        this.adminRoleDesc = adminRoleDesc == null ? null : adminRoleDesc.trim();
    }
}