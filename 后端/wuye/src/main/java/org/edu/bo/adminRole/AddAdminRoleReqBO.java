package org.edu.bo.adminRole;
public class AddAdminRoleReqBO {
    private String adminRoleName;

    private String adminRoleList;

    private String adminRoleDesc;

//    private String adminRole;
//    public String getAdminRole() {
//        return adminRole;
//    }
//
//    public void setAdminRole(String adminRole) {
//        this.adminRole = adminRole;
//    }

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

    @Override
    public String toString() {
        return "AddAdminRoleReqBO{" +
                "adminRoleName='" + adminRoleName + '\'' +
                ", adminRoleList='" + adminRoleList + '\'' +
                ", adminRoleDesc='" + adminRoleDesc + '\'' +
                '}';
    }
}
