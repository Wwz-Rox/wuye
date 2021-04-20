package org.edu.bo.adminRole;

import org.edu.common.page.BO.ReqPageBO;

public class QryAdminRoleReqBO extends ReqPageBO {
    private String adminRoleName;

    public String getAdminRoleName() {
        return adminRoleName;
    }

    public void setAdminRoleName(String adminRoleName) {
        this.adminRoleName = adminRoleName;
    }

    @Override
    public String toString() {
        return "QryAdminRoleReqBO{" +
                "adminRoleName='" + adminRoleName + '\'' +
                '}';
    }
}
