package org.edu.bo.employee;

import org.edu.common.page.BO.ReqPageBO;

public class QryEmployeeReqBO extends ReqPageBO {
    private String employeeCode;

    private String employeeName;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "QryEmployeeReqBO{" +
                "employeeCode='" + employeeCode + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
